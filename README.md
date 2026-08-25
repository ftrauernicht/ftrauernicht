## Frank Trauernicht

**Senior software engineer — C# and .NET since 2011 — Aurich, Germany**

Apprentice, engineer, head of a twelve-person development team, then seven years running my own
software company. Today I build and modernise line-of-business systems as an employed senior
engineer: greenfield services, long-lived systems that have to be moved onto current platforms
without stopping the business, and the delivery tooling around both.

Most of that work lives in private and customer repositories. What is public here is the part
that generalises — templates, patterns, and teaching material stripped of anything specific.

### Seven years running a company

For seven years I ran a software company of my own, and my half of that job was the technical
and the human one: finding the ideas worth pursuing, turning them into plans, building alongside
the team, watching the work closely enough to catch it drifting early, and keeping the whole
thing structured enough that people could do good work without waiting on me.

The people part mattered more to me than the org chart suggested — how well a team actually
gets on, and whether criticism travels freely in both directions. A team that will tell you your
idea is wrong is worth considerably more than one that agrees with you, and you earn that by how
you react the first few times it happens, not by saying you welcome it. I know reasonably well
what I am good at; I have found it more useful to know precisely where I am not, and who is
better at it than I am.

It is also what changed how I engineer. When you are still there three years later maintaining
the thing you decided, architecture stops being an aesthetic argument.

I went back to engineering full time by choice, and the planning half of that role came with me:
estimates that hold, scope that can be cut without the thing collapsing, and the habit of saying
out loud when a plan has stopped matching reality instead of hoping it recovers. Seven years
of sitting where the numbers land also left me able to read them: a technical decision is a
cost structure, and I can make that case to the people who have to sign for it.

### Architecture

I have built monoliths, modular monoliths, and microservices, and I have taken over my share of
each from someone else. The interesting question is almost never which style is best — it is which
constraints the system actually has: team size, release cadence, transactional boundaries, the
blast radius of a bad deploy, and what the organisation can realistically operate at three in
the morning. I choose on that basis and write the reasoning down, because the next engineer has
to be able to disagree with it on the evidence.

I have also spent enough time in codebases where that reasoning was never written down. Most
modernisation work is archaeology first and engineering second.

### Running systems

Some of what I build runs in the cloud and some of it runs on customer infrastructure —
regulated industries, on-premises networks, environments where the data is not allowed to leave
the building. The second kind teaches you what the first kind hides: nothing there quietly takes
care of backups, certificates, monitoring, or failover on your behalf, and that layer is yours to
build and yours to answer for. Containers and orchestration are what let the same artefact be run
by a customer's operations team and by me.

The failures I look for are the ones that produce no error at all: the transfer that stalls
instead of failing, the retry that quietly loses a message, the restore path nobody has ever
executed. The Raspberry Pi backup project below is deliberately extreme — single-core ARMv6,
512 MB RAM, unattended for years — because tight constraints make those failure modes visible
where a generously provisioned environment hides them.

### Security

Penetration testing and security reviews of applications, including mobile, that I did not
write myself, plus tooling that scans systems for privacy and GDPR exposure. Reviewing other
people's software adversarially is the fastest way I know to stop writing certain classes of
bug in my own.

### AI-assisted development

I work with LLM tooling every day and treat it as an engineering problem rather than a novelty.
The question worth answering is not whether a model can write the change; it is what has to be
true before that change is allowed to merge — architecture tests, coverage gates, secret
scanning, a diff a human can still review. Automation that cannot be verified is not automation.

### Teaching

I trained apprentices for years, several of whom finished top of their class, and mentored
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

- **Languages** — C#, TypeScript and JavaScript, Python, SQL, PowerShell, Bash
- **.NET** — ASP.NET Core, Entity Framework Core, Avalonia, xUnit
- **Data** — SQL Server, PostgreSQL
- **Operations** — Docker, Kubernetes, cloud and on-premises deployments, Linux and Windows Server, GitHub Actions, Azure DevOps Pipelines
- **Practice** — automated and architecture testing, code review, penetration testing, threat modelling, technical documentation

### Availability

Remote by default, from East Frisia in northern Germany. I travel when a piece of work genuinely
needs everyone in the same room, and I would rather make that call deliberately than out of
habit. Open to conversations about senior engineering, architecture, and modernisation work.

[LinkedIn](https://www.linkedin.com/in/frank-trauernicht/) · [XING](https://www.xing.com/profile/Frank_Trauernicht/)
