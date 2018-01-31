# Autocomplete assignment
## Lior Landesman

## General idea
My general idea was to split the input into buckets by prefix,
and search only the relevant bucket for suitable words.

## Structure
Main will poll the user continuously for prefixes, and display 3 choices for him to make.

Once the user chooses, the chosen word is given extra weight so it will be more likely to be suggested.

## Backlog
I started fiddling with a deeper structure, simulating a parse tree of the word list,
however this seemed like overkill for this type of project.

The depth of the tree will be defined by log(number of words).

Nodes insert by choosing their most suitable child and inserting the word with him.

Nodes search by finding the most suitable child node and using his getPredictions method.

Bucket would be the baseclass for both Node and Leaf.
