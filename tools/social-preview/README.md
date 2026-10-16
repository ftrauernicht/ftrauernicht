# Social preview cards

Every public repository here shows the same card when a link to it is pasted into
Slack, LinkedIn, or a chat window. This folder is what makes them the same.

It exists because they were not. The first six cards were made one at a time and
the recipe lived nowhere, so adding a seventh meant downloading the published PNGs
and measuring the design back out of them pixel by pixel. That is an hour nobody
should spend twice.

## Making a card

Add a line to `cards.tsv` — repository name, subtitle, footnote, separated by
tabs — and run:

```
bash render.sh
```

Cards land in `cards/`. The generator refuses a subtitle that needs more than two
lines rather than quietly overflowing into the rule below it.

**Render on a machine that has Georgia and Segoe UI**, which in practice means
Windows. Both ship with Windows and with nothing else, and Java does not complain
about a family it cannot find: it substitutes a default face, and the card comes out
in the wrong typeface with different line breaks and a smaller title. A CI run on
2026-10-16 rewrote all eight cards that way without a single warning. The generator
now checks the fonts first and stops with exit code 3 instead.

`.github/workflows/social-preview.yml` therefore does not render. It checks that the
folder stays consistent: every row in `cards.tsv` has a card, every card has a row,
and the generator still compiles. That catches the mistake that actually happens,
which is a row added and the render forgotten.

## Putting it on GitHub

By hand, and there is no way around it: **GitHub has no API for the social
preview image.** It is not a field on the repository object, and `PATCH` with
`open_graph_image_url` is accepted and ignored. The only route is

> Repository → Settings → General → Social preview → Upload an image

Which also means a card can silently go missing when a repository is renamed or
recreated. `og:image` in the repository's HTML tells you which repositories still
have one: a URL under `repository-images.githubusercontent.com` is a real card, one
under `opengraph.githubassets.com` is GitHub's generated fallback.

## The design, as measured

Canvas 1280 × 640, which is what GitHub displays.

| | |
|---|---|
| Paper | `#FBF8F3` |
| Ink | `#191713` |
| Muted | `#6D6152` |
| Accent | `#A4552B` |
| Hairline | `#E6DCCD` |

Left margin 90, right edge 1190, so the content is 1100 wide.

| Element | Font | Baseline |
|---|---|---|
| Repository name | Georgia 84 | x 90, y 212 |
| Accent rule | — | x 90, y 244, 65 × 5 |
| Subtitle, up to two lines | Segoe UI 34 | x 90, y 317, leading 45 |
| Footnote | Segoe UI 26, muted | x 90, y 409 |
| Hairline | — | x 90, y 548, 1100 × 2 |
| Name | Georgia Bold 28 | x 90, y 592 |
| Role | Segoe UI 26, muted | right-aligned to 1190, y 599 |

A long repository name is set smaller rather than allowed to run past the margin,
and the whole block above the hairline is centred on y 275, so a one-line subtitle
sits lower than a two-line one. Both rules were read back out of the published
cards; nothing above the hairline sits at a fixed height.

**Georgia and Segoe UI are Windows system fonts.** On a machine without them, Java
substitutes something else and the card comes out wrong without saying so. If this
ever has to run elsewhere, ship the two faces alongside and load them with
`Font.createFont`.

### Where the published cards and this generator disagree

Five of the seven regenerate to within anti-aliasing noise. Two do not, and it is
worth knowing why before anybody goes looking for a bug:

| Repository | Published title | This generator |
|---|---|---|
| `dotnet-architecture-hexagonal-template` | 1060 px wide | 1093 px |
| `fachinformatiker-anwendungsentwicklung` | 1049 px wide | 1090 px |

Both have names too long for 84 pt. They were sized by hand, a little smaller than
"as large as still fits", before any rule existed. The generator fills the width.
Nothing is wrong with either card; they are simply from before the rule. Re-upload
the two if you ever want all seven to come from the same source.

## Writing the three strings

The subtitle says what the repository is, in one sentence, with no verb missing. It
is the line somebody reads instead of the README.

The footnote carries two facts separated by ` · ` — two spaces either side. They are
the things that distinguish this repository from a tutorial somebody abandoned:
that it is bilingual, that CI proves something, that it needs no toolchain. Not
adjectives.

Neither line sells. The card is a label, not a pitch.
