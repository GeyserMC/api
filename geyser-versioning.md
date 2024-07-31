# Geyser Versioning

This document discusses how versioning in Geyser is handled and the expectations for when version bumps should or should not occur.

## Versioning Scheme
Geyser loosely follows the [Romantic Versioning](https://github.com/romversioning/romver) scheme. This is more practical than Semantic Versioning as it enforces more real-world principles and considers the nuances of the Minecraft development ecosystem and the Geyser project structure.

Romantic Versions incorporates the following version scheme: HUMAN.MAJOR.MINOR
- The **HUMAN** version represents any large conceptual change, major rewrite, or any other change which requires additional HUMAN involvement. HUMAN should only ever be bumped if projects relying on the API versions are fundamentally incompatible with the previous version.
- The **MAJOR** version represents any large change to the API, where incompatible API changes may occur, or large conceptual changes that have the potential to break API behavior. Major versions may be compatible with one another in the short term, but large gaps between major versions (i.e. 1.2 and 1.6) may see compatibility breaks.
- The **MINOR** version represents any additional functionality added in a backward-compatible manner or fix with backward-compatible bug fixes. This could also include deprecations. Minor versions will **always** be backwards compatible with each other.

## API Versions
As Geyser has 2 separate APIs, a core project module, and often sees changes due to both Minecraft Java and Bedrock's own updates which don't necessarily follow a specific versioning sceheme, simply using Semantic Versioning is unrealistic.

To dig a bit deeper into the APIs Geyser has:
- **Base API** is an API that is shaded into both Geyser and Floodgate. It is a shared API that developers can use when they want to create a Geyser project that may only have access to one or the other
- **Geyser API** is an API shaded exclusively into Geyser. While it contains many more features, it is only available in instances where Geyser is installed

With Geyser versioning, Base API will have its own version independent of Geyser API.

## Base API Versioning

### Base API should be updated any time a change occurs in the **Base API** only
- Changes in Geyser, unless they require changes to the Base API, should not change the Base API version
### Changes in the base API should result in a corresponding bump in the **Geyser API** as the Geyser API relies on Base API
- The version type updated (human, major, minor) should be reflected the same way across both APIs
- Example: Base API is updated from 1.0.1 -> 1.0.2. Geyser API should be bumped from (2.2.3 -> 2.2.4)
- This also includes HUMAN bumps
    - A change large enough to constitute a HUMAN bump will have repercussions for the Geyser API too

## Geyser Versioning

### Geyser API shares the same versioning as the Geyser project as a whole
- This is to ensure consistency for developers and to reduce confusion
- Maintaining multiple project versions becomes cumbersome and anyone wishing to rely on Geyser internals for any reason may mismatch versions if multiple versions are relied upon
### Any new, non-breaking API added to Geyser will bump the MINOR version
- API changes will typically be stashed in an `api/<version>` branch for a short period before the API is finalized and merged into the main project
- Multiple APIs may be added to this branch at the same time and released in the same version. This is to avoid lots of needless bumps if multiple APIs are to be added in a short period of time
- Deprecations may be added with the addition of new APIs, but no deprecated code should be removed during this time
- Version branches should not sit any longer than a week or two to avoid any API becoming stale
### Every minor Minecraft update (i.e. 1.20.10 -> 1.20.20) will result in a MINOR bump to the API
- Any outstanding API changes will be merged in during this time
- Even if no API is merged during a minor version, this is a conceptual bump to indicate that a change has occurred to end users
### Any substantial APIs or removals of deprecated code will bump the MAJOR version
- Any subsantial API is likely to become ubiquitous in time and thus making changes to it becomes challenging
- Substantial APIs should sit longer in a queue to ensure quality and that all potential concerns are addressed
- MAJOR bumps should be reserved for Minecraft updates, unless a major change occurs in the Base API
### Every major Minecraft update (i.e. 1.20 -> 1.21) will result in a MAJOR bump to the API
- Conceptually, new major Minecraft versions are associated with large changes
- Reserving large changes and deprecated code removals with an expected standard makes development much easier across the community and brings larger changes at an expected time
    - Code breaks during random intervals make development more challenging
    - The main exception is if the **Base API** sees a major version bump
        - Typically, in this case, it is in anticipation of a larger set of changes coming to the Geyser project that will have already been communicated
        - It should not be expected, unless the Base API changes require it, that any code exclusive to the Geyser API will break
### Deprecated API should typically be removed two Minecraft versions after it becomes deprecated
- Establishes a common policy devs can expect when a method suddenly becomes deprecated
- In any case, the deprecation notice in API should specify the version it became deprecated in, and when it is expected to be removed
- More ubiquitous API should have a longer expected removal time in its deprecation notice
- API should typically **never** be removed outside of a MAJOR version bump
    - The one exception to this may include poor API that managed to make it into the project, but was small enough and had such a limited lifespan (i.e. a few hours) that it was never adopted
- API may be removed earlier if it recieved a deprecation and replacement shortly after it's inception (i.e. a few weeks), or it's no longer functioning due to internal or Minecraft changes
### Massive API changes should bump the HUMAN version
- Any major change to fundamental APIs should bump the HUMAN version
- Any changes that constitute a bump to the MAJOR version bundled together may constitute a HUMAN bump
    - Example: A large number of deprecated events inside the Geyser API get removed in one batch. Removing a single event alone may only constitute a MAJOR bump, but a large removal all together has a far wider impact across the community

## Final Notes
This is meant to serve as a guide and establish a set of standards when updating the Geyser project versions. It should also be noted that none of this is final and that this versioning specification may change in time if developments within the ecosystem constitute it (i.e. Minecraft starts releasing 5 major game versions a year).

When required, exceptions may occur in certain scenarios, which will be communicated through [Discord](https://discord.gg/geysermc).