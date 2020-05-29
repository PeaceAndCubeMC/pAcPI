# pAcPI
An API to help creating plugins for PeaceAndCube

## Features

### Command
Various useful commands
- ``/removealltags <target> [<except>]`` to remove all scoreboard tags from the target. The tag specified in ``except`` will be ignored.

### Date
- ``DateUtils`` provides utility methods to get current day in several formats.
- ``LocalizedMonth`` provides month number, localized month name and maximum days.

### Player
- ``PlayerErrors`` provides generic error messages.
- ``PlayerSuggestionProviders`` provides generic lists of strings, used by command tab completion.
