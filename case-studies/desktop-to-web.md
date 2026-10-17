# From desktop to web, without stopping the business

A decision from my time at BUSS DATA GmbH, 2011 to 2019. I made it as a software engineer
responsible for architecture and the technical calls, and finished it as head of software
development. The company's customers and systems stay unnamed; the decision reads fine
without them.

## Where things stood

Several independent line-of-business applications on the desktop, C# and WinForms, each with
its own history and its own users. There was no shared core holding them together. The
platform they sat on had no future.

The team could not build web interfaces at that point. HTML, CSS and JavaScript were new to
them, and so was the move from thinking in windows and events to thinking in request and
response. That was not a weakness but a constraint, like the platform.

## What was on the table

Technically nothing was fixed. No database had to survive, no third-party interface dictated
anything, no installed environment at a customer narrowed the field. I could have rewritten
every one of those applications from scratch, and there was a case for it: the structures had
grown in a time when nobody was thinking about the web, and a rewrite would have shed them in
one go.

## The decision

I replaced the user interface. The logic and the data access stayed, with an ASP.NET Core
Razor front end in front of them. The NHibernate mapping onto PostgreSQL stayed untouched,
not because it had to but because I wanted to keep it.

The deciding factor was the team. An unfamiliar interface technology and a freshly written
core at the same time would have been two building sites in a house where nobody had seen the
first one before. With several applications and no shared core, a rewrite would also have
been a separate rewrite each time rather than one for all of them.

What it cost belongs here too. The old structures came along. What a rewrite would have
cleared up in passing stayed where it was and had to be touched a second time later. Nothing
was saved; it was deferred.

## The process alongside it

I introduced Scrum and the quality standards over those same years, running next to the
move. No plan behind that, just the order things happened in.

## What changed

A release reached its users without anyone walking to individual machines. The part of
support that consisted of version mismatches and installation problems disappeared along
with the installer. And enquiries became possible that the desktop version could not have
served.

I am not quoting numbers, because I did not measure them at the time. The statements above
hold without them.

## What I would do differently

Put the process first. Cadence and quality assurance belong before a move like this, not
beside it. As it went, the team had to learn two things at once, a new technology and a new
way of working, and that cost more than it needed to. Whether the interface decision would
have come out differently, I do not know. It would at least have been a judgement about the
software rather than a concession to the team.
