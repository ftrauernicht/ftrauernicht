## Frank Trauernicht

**Senior software engineer — C# and .NET since 2011 — Aurich, Germany**

- Architecture and modernisation of long-lived line-of-business systems
- Apprentice, engineer, head of a twelve-person development team
- Seven years running a software company of my own
- Cloud and on-premises, containers, CI/CD, security reviews and penetration testing
- Remote by default, from East Frisia in northern Germany

Today that means greenfield services, long-lived systems that have to move onto current
platforms without stopping the business, and the delivery tooling around both.

### Seven years running a company

My half of running the company was the technical and the human one: finding the ideas worth
pursuing, turning them into plans, building alongside the team, and keeping things structured
enough that people could work without waiting on me. It also changed how I engineer — when you
are still there three years later maintaining what you decided, architecture stops being an
aesthetic argument.

The people part mattered more to me than the org chart suggested: whether a team actually gets
on, and whether criticism travels in both directions. A team that will tell you your idea is
wrong is worth more than one that agrees with you. I know reasonably well what I am good at; I
have found it more useful to know precisely where I am not, and who is better at it than I am.

I went back to engineering full time by choice, and the planning half came with me: estimates
that hold, scope that can be cut without collapsing, and the habit of reading the numbers. A
technical decision is a cost structure, and I can make that case to the people who sign for it.

### Architecture

Monolith, modular monolith, microservices, and everything improvised in between: these
structures exist, and you rarely get to choose which one is in front of you. The work is being
able to handle whichever it turns out to be — the one you designed as much as the one you
inherited.

Which style is best is rarely the interesting question. What matters is the constraints the
system actually has: team size, release cadence, transactional boundaries, the blast radius of a
bad deploy, and what the organisation can operate at three in the morning. I choose on that
basis and write the reasoning down, because the next engineer has to be able to disagree with it.

I have also spent enough time in codebases where that reasoning was never written down. Most
modernisation work is archaeology first and engineering second.

### Running systems

Some of what I build runs in the cloud, some on customer infrastructure — regulated industries,
on-premises networks, environments where the data is not allowed to leave the building. The
second teaches you what the first hides: nothing there quietly handles backups, certificates,
monitoring, or failover for you. Containers and orchestration are what let the same artefact
run on a customer's infrastructure and on mine.

The failures worth looking for are the ones that produce no error at all: the transfer that
stalls instead of failing, the retry that quietly loses a message, the restore path nobody has
ever executed. The Raspberry Pi project below is deliberately extreme, because tight constraints
make those failure modes visible where a generously provisioned environment hides them.

### Security

Penetration testing and security reviews of applications, including mobile, that I did not write
myself, plus tooling that scans for privacy and GDPR exposure. Reviewing other people's software
adversarially is the fastest way I know to stop writing certain classes of bug in my own.

### AI-assisted development

The question worth answering about LLM tooling is not whether a model can write the change; it
is what has to be true before that change is allowed to merge — architecture tests, coverage
gates, secret scanning, a diff a human can still review. Automation that cannot be verified is
not automation.

### Teaching

I trained apprentices for years, several of whom finished top of their class, and mentored
developers as a team lead. The material I write is public because it is only useful if someone
can pick it up and get moving without me in the room.

### Selected repositories

Most of my work lives in private and customer repositories. What is public is the part that
generalises — templates, patterns, and teaching material stripped of anything specific.

| Repository | What it is |
|---|---|
| [dotnet-architecture-hexagonal-template](https://github.com/ftrauernicht/dotnet-architecture-hexagonal-template) | A .NET 10 setup taken far enough to be honest about the cost: the dependency rule enforced by architecture tests, xUnit v3 and Reqnroll, Central Package Management, and a five-stage CI/CD pipeline on SHA-pinned workflows. |
| [javascript-course](https://github.com/ftrauernicht/javascript-course) | Project-based JavaScript course for beginners and apprentices, German and English side by side, building from the browser console up to a GUI calculator, quiz, and memory game. |
| [raspi-google-drive-sync](https://github.com/ftrauernicht/raspi-google-drive-sync) | Unattended backup on deliberately weak hardware: read-only OAuth, copy instead of sync, a watchdog for stalled transfers, and a disk layout that stays readable when the machine running it is gone. |
| [ha-automation-cookbook](https://github.com/ftrauernicht/ha-automation-cookbook) | Home Assistant patterns written to be reused and read, one per folder — alongside sun-aware cover control that yields to manual override and time-in-zone statistics computed in SQL. |

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
