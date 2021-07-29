# pAcPI
An API to help creating plugins for PeaceAndCube

## Features

### Command
Various useful commands
- ``/removealltags <target> [<except>]`` to remove all scoreboard tags from the target. The tag specified in ``except`` will be ignored.
- ``/chrono (start|end) <target>`` to start or end a player timer.
- ``/resourcepack send <target> <url>`` to send a resource pack to a target.

### Date
- ``Chrono`` provides a player-specific timer that can be started and ended.
- ``DateUtils`` provides utility methods to get current day in several formats.
- ``LocalizedMonth`` provides month number, localized month name and maximum days.

### Player
- ``PlayerMessages`` provides feedback messages.
- ``PlayerSuggestionProviders`` provides generic lists of strings, used by command tab completion.

### Gameplay
- When a player places an item frame or a glow item frame renamed "invisible", the item frame entity gets the ``Invisible`` tag.
