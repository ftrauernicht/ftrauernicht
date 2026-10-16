import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * Builds the GitHub social preview card used by every public repository of
 * ftrauernicht. The numbers below were measured back out of the existing cards,
 * pixel by pixel, because they had never been written down.
 *
 *   javac SocialPreview.java
 *   java  SocialPreview <out.png> "<repo-name>" "<subtitle>" "<footnote>"
 */
public final class SocialPreview {

    // GitHub displays the card at 1280x640.
    static final int W = 1280, H = 640;
    static final int MARGIN = 90;
    static final int RIGHT = W - MARGIN;
    static final int CONTENT = RIGHT - MARGIN;

    static final Color PAPER = new Color(0xFBF8F3);
    static final Color INK = new Color(0x191713);
    static final Color MUTED = new Color(0x6D6152);
    static final Color ACCENT = new Color(0xA4552B);
    static final Color HAIRLINE = new Color(0xE6DCCD);

    static final String TITLE_FACE = "Georgia";
    static final String TEXT_FACE = "Segoe UI";
    static final int TITLE_MAX = 84;

    static final Font SUBTITLE = new Font(TEXT_FACE, Font.PLAIN, 34);
    static final Font FOOTNOTE = new Font(TEXT_FACE, Font.PLAIN, 26);
    static final Font NAME = new Font(TITLE_FACE, Font.BOLD, 28);
    static final Font ROLE = new Font(TEXT_FACE, Font.PLAIN, 26);

    // Offsets below the title baseline. Everything above the hairline moves as
    // one block; only these distances are fixed.
    static final int RULE_DROP = 32, RULE_W = 65, RULE_H = 5;
    static final int SUBTITLE_DROP = 73;      // below the rule's top edge
    static final int SUBTITLE_LEADING = 45;
    static final int FOOTNOTE_DROP = 47;      // below the last subtitle baseline

    // The block is centred on this line. Measured at 279 to 281 across the
    // existing cards; 275 is what reproduces their ink bands exactly.
    static final int BLOCK_CENTRE = 275;

    static final int HAIRLINE_Y = 548, HAIRLINE_H = 2;
    static final int NAME_BASELINE = 592, ROLE_BASELINE = 599;

    static final String PERSON = "Frank Trauernicht";
    static final String ROLE_TEXT = "Senior Software Engineer";

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.err.println("usage: SocialPreview <out.png> <repo> <subtitle> <footnote>");
            System.exit(2);
        }
        System.setProperty("java.awt.headless", "true");

        // Georgia and Segoe UI ship with Windows and with nothing else. Java does not
        // complain when a family is missing; it quietly hands back a default face, and
        // the card then comes out in the wrong typeface with different line breaks and
        // a different title size. That is invisible until the cards sit side by side.
        requireFonts(TITLE_FACE, TEXT_FACE);

        BufferedImage img = new BufferedImage(W, H, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = img.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        FontRenderContext frc = g.getFontRenderContext();

        g.setColor(PAPER);
        g.fillRect(0, 0, W, H);

        // A long repository name is set smaller rather than allowed to run off
        // the edge. dotnet-architecture-hexagonal-template is the reason.
        Font title = fitTitle(args[1], frc);
        List<String> lines = wrap(args[2], SUBTITLE, frc);
        if (lines.size() > 2) {
            System.err.println("subtitle needs " + lines.size()
                    + " lines; the card has room for two. Shorten it.");
            System.exit(1);
        }

        // Lay the block out from an arbitrary baseline, then shift it so that
        // its centre lands on BLOCK_CENTRE.
        int titleBaseline = 0;
        int ruleTop = titleBaseline + RULE_DROP;
        int firstSubtitle = ruleTop + SUBTITLE_DROP;
        int lastSubtitle = firstSubtitle + (lines.size() - 1) * SUBTITLE_LEADING;
        int footnote = lastSubtitle + FOOTNOTE_DROP;

        int top = titleBaseline - g.getFontMetrics(title).getAscent();
        int bottom = footnote + g.getFontMetrics(FOOTNOTE).getDescent();
        int shift = BLOCK_CENTRE - (top + bottom) / 2;

        titleBaseline += shift;
        ruleTop += shift;
        firstSubtitle += shift;
        footnote += shift;

        g.setColor(INK);
        g.setFont(title);
        g.drawString(args[1], MARGIN, titleBaseline);

        g.setColor(ACCENT);
        g.fillRect(MARGIN, ruleTop, RULE_W, RULE_H);

        g.setColor(INK);
        g.setFont(SUBTITLE);
        for (int i = 0; i < lines.size(); i++) {
            g.drawString(lines.get(i), MARGIN, firstSubtitle + i * SUBTITLE_LEADING);
        }

        g.setColor(MUTED);
        g.setFont(FOOTNOTE);
        g.drawString(args[3], MARGIN, footnote);

        g.setColor(HAIRLINE);
        g.fillRect(MARGIN, HAIRLINE_Y, CONTENT, HAIRLINE_H);

        g.setColor(INK);
        g.setFont(NAME);
        g.drawString(PERSON, MARGIN, NAME_BASELINE);

        g.setColor(MUTED);
        g.setFont(ROLE);
        int roleW = (int) ROLE.getStringBounds(ROLE_TEXT, frc).getWidth();
        g.drawString(ROLE_TEXT, RIGHT - roleW, ROLE_BASELINE);

        g.dispose();
        ImageIO.write(img, "png", new File(args[0]));
        System.out.println("written: " + args[0] + "  " + W + "x" + H
                + "  title " + title.getSize() + "pt, subtitle on "
                + lines.size() + " line(s)");
    }

    static Font fitTitle(String text, FontRenderContext frc) {
        for (int size = TITLE_MAX; size > 20; size--) {
            Font f = new Font(TITLE_FACE, Font.PLAIN, size);
            if (f.getStringBounds(text, frc).getWidth() <= CONTENT) {
                return f;
            }
        }
        return new Font(TITLE_FACE, Font.PLAIN, 20);
    }

    static List<String> wrap(String text, Font font, FontRenderContext frc) {
        List<String> out = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (String word : text.split(" ")) {
            String candidate = line.isEmpty() ? word : line + " " + word;
            if (font.getStringBounds(candidate, frc).getWidth() > CONTENT && !line.isEmpty()) {
                out.add(line.toString());
                line = new StringBuilder(word);
            } else {
                line = new StringBuilder(candidate);
            }
        }
        if (!line.isEmpty()) {
            out.add(line.toString());
        }
        return out;
    }

    /** Stops rather than silently substituting a face the machine does not have. */
    static void requireFonts(String... faces) {
        List<String> have = Arrays.asList(GraphicsEnvironment
                .getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        for (String face : faces) {
            if (!have.contains(face)) {
                System.err.println("Missing font: " + face
                        + ". The cards are rendered on a machine that has it, which in"
                        + " practice means Windows. Rendering here would produce a card"
                        + " in a different typeface without saying so.");
                System.exit(3);
            }
        }
    }
}
