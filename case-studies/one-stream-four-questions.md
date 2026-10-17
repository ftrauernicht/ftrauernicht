# One data stream and four questions asked of it

A decision from my time at Leanetec GmbH, 2019 to 2026, the company I co-founded. I was the
managing director on the technical side and, latterly, a senior engineer. Customers and their
systems stay unnamed.

## Where things stood

Position reports from ship traffic across a bounded area, arriving continuously, and readings
from sensors alongside them. Four to five million records a month, with no single day standing
out. The stream does not ask whether anyone is watching, and the body of data it leaves behind
grows every day.

Four things had to be possible:

- the current picture on a map, there the moment you open it
- analysis across weeks and months
- replaying an individual track step by step after the fact
- rules that check as data arrives and report on their own

Those four pull apart. The map wants a current state kept ready. The analysis wants
aggregation. The individual track requires that nothing was discarded. And the rule checks
have to keep pace with the stream.

## Where the obvious approach stopped working

It started the way these systems almost always start: everything into one table, queries
straight over it. The limit showed up on the map. Showing the current picture meant searching
the whole body of data, and that grew more expensive every month.

The heavy analysis was not the first thing to give; the view people opened most often was.
Watching only your most expensive query means watching the wrong place.

## What was on the table

Nothing was fixed. Neither the storage nor the processing was prescribed to me, which is what
makes this a real decision. Three routes were serious candidates.

Aggregate on write and drop the raw data after a retention period. Small, fast and final:
what is gone answers no question somebody asks two years later.

Keep computing everything from the raw data, with partitioning and the right indexes. One
truth rather than two, at the price of query times you have to explain to a user.

A second store for time series alone. The cleanest fit on paper, and a second system in
production that everyone on the team has to know.

## The decision

The raw data stayed complete, and an aggregated layer went beside it: precomputed state for
the map and for the analysis, the raw data for anything concerning an individual track. Each
of the four demands keeps its own path to the same data.

The price is two states that have to agree. Every change to the processing touches both, and
a fault in the aggregation surfaces only when somebody compares two numbers that no longer
match. That obligation does not end. It runs for as long as the system does.

## How the decision was underwritten

Build and delivery through Jenkins pipelines, operation in Docker networks behind reverse
proxies, DevSecOps standards, and written documentation of the source and the system
architecture.

With an inbound stream that never pauses, none of that is a garnish. Changing a processing
step that is continuously being fed requires an environment in which yesterday's state can be
restored. Without one, every change is an experiment on the running system.

## What changed

Questions spanning months became answerable instead of running out of time. The map was there
when you opened it, regardless of how much had accumulated behind it.

## What I would do differently

Plan the aggregation from the start. I built it when the map got slow, and by then it was a
rebuild on a running system rather than a question in the design. That a data stream needs a
second, aggregated state as soon as somebody looks at it regularly is foreseeable before
the first line is written. I did not foresee it.
