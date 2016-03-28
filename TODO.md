# TODO

## Smells

* there's a primitive obsession with ints. see commit = 60125ff
* can data clump the {{standard, automated} factory, {raw, finished} material}. see commit = 79351cf

## Functional

* in Monthly operations -> bid for supplies, we need to make sure that the bank does not cumulate the units from one turn to the next one.
* no notion of junior to senior player. this, at least, affects while deciding priorities in case there is a tie

## TDD

 * shell only in produce stock