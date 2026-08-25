## Frank Trauernicht

**Senior software engineer — C# and .NET since 2011 — Aurich, Germany**

Apprentice, engineer, head of a twelve-person development team, then seven years running my own
software company. Today I build and modernise line-of-business systems as an employed senior
engineer: greenfield services, long-lived systems that have to be moved onto current platforms
without stopping the business, and the delivery tooling around both.

Most of that work lives in private and customer repositories. What is public here is the part
that generalises — templates, patterns, and teaching material stripped of anything specific.

### Seven years running a company

I founded and ran a software company for seven years: hiring and paying the team, winning the
customers, setting the technical direction, and carrying the consequences of all three. It is
the single experience that changed how I engineer. When the maintenance cost of a shortcut
lands on your own budget three years later, architecture stops being an aesthetic argument.

I went back to engineering full time by choice, and the commercial half of the job came with
me: estimates that hold, scope that can be cut without the thing collapsing, and a straight
answer about what something will actually cost to run.

### Architecture

I have shipped monoliths, modular monoliths, and microservices, and I have inherited all three
from other people. The interesting question is almost never which style is best — it is which
constraints the system actually has: team size, release cadence, transactional boundaries, the
blast radius of a bad deploy, and what the organisation can realistically operate at three in
the morning. I choose on that basis and write the reasoning down, because the next engineer has
to be able to disagree with it on the evidence.

I have also spent enough time in codebases where that reasoning was never written down. Most
modernisation work is archaeology first and engineering second.

### Reliability

A system that only works while someone watches it is not finished. What I look for is the
failure that produces no error at all: the transfer that stalls instead of failing, the retry
that quietly loses a message, the restore path nobody has ever executed. The Raspberry Pi
backup project below is deliberately extreme — single-core ARMv6, 512 MB RAM, unattended for
years — because tight constraints make those failure modes visible where a generously
provisioned environment hides them.

### AI-assisted development

I work with LLM tooling every day and treat it as an engineering problem rather than a novelty.
The question worth answering is not whether a model can write the change; it is what has to be
true before that change is allowed to merge — architecture tests, coverage gates, secret
scanning, a diff a human can still review. Automation that cannot be verified is not automation.

### Teaching

I trained apprentices for years, several of whom finished top of their class, and I mentored
developers as a team lead. The material I write is public for the same reason it worked then:
it is only useful if someone can pick it up and get moving without me in the room.

### Selected repositories

| Repository | What it is |
|---|---|
| [dotnet-architecture-hexagonal-template](https://github.com/ftrauernicht/dotnet-architecture-hexagonal-template) | One way to set up a .NET 10 application, taken far enough to be honest about the cost: the dependency rule enforced by architecture tests, xUnit v3 and Reqnroll, Central Package Management, SHA-pinned workflows, and a five-stage CI/CD pipeline. A starting point to argue with, not a house style. |
| [javascript-course](https://github.com/ftrauernicht/javascript-course) | Project-based JavaScript course for beginners and apprentices, German and English side by side, building from the browser console up to a GUI calculator, quiz, and memory game. |
| [raspi-google-drive-sync](https://github.com/ftrauernicht/raspi-google-drive-sync) | Unattended backup on deliberately weak hardware. Read-only OAuth, copy instead of sync, a watchdog for stalled transfers, and a disk layout that stays readable when the machine running it is gone. |
| [ha-automation-cookbook](https://github.com/ftrauernicht/ha-automation-cookbook) | Home Assistant automation patterns written to be reused and read, one per folder, rather than a dump of a personal configuration. |
| [ha-sun-blind-automation](https://github.com/ftrauernicht/ha-sun-blind-automation) | Sun-aware cover control that detects and yields to manual override — a small study in automation that does not fight its user. |
| [ha-zone-time-stats](https://github.com/ftrauernicht/ha-zone-time-stats) | Per-person time-in-zone statistics computed in SQL instead of a stack of helper entities. |

### Tools

**Languages** C#, TypeScript and JavaScript, Python, SQL, PowerShell, Bash
**.NET** ASP.NET Core, Entity Framework Core, Avalonia, xUnit
**Data** SQL Server, PostgreSQL, Firebird
**Delivery** Docker, GitHub Actions, Azure DevOps Pipelines, trunk-based Git workflows
**Practice** automated and architecture testing, code review, threat modelling, technical documentation

### Contact

[LinkedIn](https://www.linkedin.com/in/frank-trauernicht/) · [XING](https://www.xing.com/profile/Frank_Trauernicht/)
