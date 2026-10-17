# The first weeks in a system nobody can explain

I describe modernisation as archaeology first and engineering second. This is what the
archaeology part consists of, written down because the claim is easy to make and harder to
show.

It assumes the common case: a system that has been earning money for years, documentation
that stopped being true at some point, and nobody left who was in the room for the original
decisions.

## What you are looking for is not in the code

The source tells you what the system does. It never tells you why, and every oddity in front
of you is one of two things. Either somebody got it wrong, or it is a scar from a requirement
that was real and is written down nowhere. Change the first and you have improved the system.
Change the second and you have broken a customer who will take two months to notice.

You cannot tell the two apart by reading. You tell them apart by finding the people, the
tickets, the commit messages and the old mail threads, in that order of usefulness.

## Start at the edges

The middle of a long-lived system is large and mostly beside the point in week one. The edges
are where its obligations live: the imports, the exports, the scheduled jobs, the reports
somebody receives on the first of the month, the interface to a system that belongs to
somebody else. Those are the promises the organisation has made.

Almost every one of these systems has an interface that is documented nowhere. Looking for it
is a task of its own, because it is not something you notice in passing, and it stops being
cheap to find the moment you change anything behind it.

## Find out what is running

The repository describes a system. Production runs one. The distance between them is where
the unpleasant surprises are kept: a configuration value nobody knows the origin of, a job on
a machine that is not in any inventory, a version deployed by hand in a hurry two years ago.

Ask for the deployment. Then reconstruct the path from commit to running process. If nobody
can describe that path, you have found the first thing worth fixing, and it is a process
problem before it is an architectural one.

## Make it observable before you make it better

You cannot safely change what you cannot watch fail. The failures that matter in these
systems rarely announce themselves: the transfer that stalls instead of erroring, the retry
that quietly drops a message, the restore path nobody has ever executed. Nobody has ever been
paged for any of them, which is how they survive for years.

Put the watching in first. It changes nothing functionally, and it is what tells you
afterwards whether your change was an improvement or a slower outage.

It also tells you where to look, which is not where you think. There is
[a case study in this repository](../case-studies/one-stream-four-questions.md) about a
continuous stream of position data. The limit there turned up on the map, the view people
opened most often, and not on the heavy analysis across months. I had not planned the
aggregation that fixed it, so it arrived as a rebuild on a running system instead of a
question in the design.

## Build the net where you intend to cut

Full test coverage of a system you have known for three weeks is a project, not a
precaution. What pays is a thin layer of tests on the seam you are about to cut, written
against current behaviour, including the behaviour that looks wrong to you.

That last part gets objected to on the grounds that you are freezing a bug in place. The
tests claim nothing about correctness. They tell you that something changed, and a test that
pins down a bug has done its job the day the bug disappears without anyone intending it.

Which seam you cut is a decision in its own right, and the architecture rarely makes it for
you. In [the move from desktop to web](../case-studies/desktop-to-web.md) I cut between the
user interface and everything behind it and left the logic where it was, because the team had
never built a web interface and could not carry two unfamiliar things at once. The old
structures came along and had to be touched a second time later. That is what the seam cost,
and it was the right seam anyway.

## Write down what you find while it still looks strange

The first weeks are the only time you see the system with outside eyes. Six weeks later the
oddities look normal to you too, and the explanation you would have written is gone.

So write the decisions down as decisions, with the alternative that was rejected and what it
would have cost. Not because documentation is virtuous, but because the next person has to be
able to disagree with you on the merits. A decision without its reasoning is indistinguishable
from an accident, and that is how you ended up in this position.

## When to skip most of this

If the system is being switched off within the year, most of the above is wasted effort and
the honest move is a thin safety net and nothing else. The work described here earns its cost
on systems that will outlive the team currently holding them.
