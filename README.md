## Frank Trauernicht

Senior software engineer in East Frisia, Germany. I have been building on .NET since 2011 —
first as an apprentice, later leading a twelve-person development team, then running a software
company for six years. Today I work on line-of-business systems, legacy migrations, and the
tooling around them.

What interests me is the part of a system that is still standing in five years: an architecture
that resists erosion because tests enforce it, a build that fails loudly instead of drifting
quietly, and documentation a stranger can act on without asking me anything. Most of my
professional work lives in private repositories, so this account is where the reusable,
generic parts of it end up.

### What I work on

**Architecture and .NET.** Clean/hexagonal designs in which the dependency rule is a test rather
than a convention. Central Package Management, pinned SDKs, SHA-pinned workflows, and
package-source mapping against dependency confusion — supply-chain hygiene treated as part of
the architecture instead of an afterthought.

**Systems and self-hosting.** Unattended services that have to survive years of neglect on weak
hardware: watchdogs that detect a stalled transfer rather than a dead process, storage layouts
that stay readable when the machine running them is gone, and restores that need no proprietary
tooling.

**Home automation.** Home Assistant setups written as reusable, copy-pasteable patterns instead
of one-off YAML — sun-aware cover control that yields to manual override, presence statistics
computed in SQL rather than by a stack of helper entities.

**AI-assisted development.** I use LLM tooling daily and care about the boundary conditions:
where a generated change still has to pass architecture tests, coverage gates, and secret
scanning before it counts as done. Automation that cannot be verified is not automation.

**Teaching.** I trained apprentices for years, several of whom finished top of their class. The
teaching material I write is public for the same reason it worked then: it is only useful if
someone can pick it up without me in the room.

### Selected repositories

| Repository | What it is |
|---|---|
| [dotnet-architecture-hexagonal-template](https://github.com/ftrauernicht/dotnet-architecture-hexagonal-template) | .NET 10 clean/hexagonal starter. Dependency rule enforced by architecture tests, xUnit v3 + Reqnroll, Avalonia MVVM, and a five-workflow CI/CD pipeline that ships a single-file executable. |
| [javascript-course](https://github.com/ftrauernicht/javascript-course) | Project-based JavaScript course for beginners and apprentices, German and English side by side. Builds up from the browser console to a GUI calculator, quiz, and memory game. |
| [raspi-google-drive-sync](https://github.com/ftrauernicht/raspi-google-drive-sync) | Self-healing Google Drive and Photos backup on a Raspberry Pi. Read-only OAuth, `rclone copy` instead of sync, mergerfs over two USB disks that each stay readable standalone. |
| [ha-automation-cookbook](https://github.com/ftrauernicht/ha-automation-cookbook) | Independent, copy-pasteable Home Assistant automation patterns, one per folder. |
| [ha-sun-blind-automation](https://github.com/ftrauernicht/ha-sun-blind-automation) | Sun-aware blind and cover control with manual-override detection, written as a reusable template rather than a personal config. |
| [ha-zone-time-stats](https://github.com/ftrauernicht/ha-zone-time-stats) | Per-person time-in-zone statistics via pure SQL sensors, including a safe way to archive JSON through a shell command. |

### Tools

C# and .NET, ASP.NET Core, Avalonia, EF Core, SQL Server and PostgreSQL, Docker, GitHub Actions
and Azure DevOps Pipelines, PowerShell and Bash, Python, JavaScript and TypeScript, Linux server
administration, Home Assistant.

### Elsewhere

[LinkedIn](https://www.linkedin.com/in/frank-trauernicht/) · [XING](https://www.xing.com/profile/Frank_Trauernicht/)
