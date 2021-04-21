# hangman-word-computation
Assists hangman game (in development).

To make hangman more playable against a computer opponent, this program will compute the difficult of random English words. When playing the game, the computer will then only select guessing words within that difficulty level.

This process was done using a function that combines values from a word frequency file, and word length to output a difficulty value. 

This method broke down when computing easy words that became longer when a suffix was added. For example, 'jump' would be marked as easy, but 'jumping' was given an unreasonably high difficulty value (even though it is still an easy word to guess). To mitigate this, I allowed the program to identify the roots of some of these words and remove the ending, and then compute it. 

  E.g. jumping -----> (jump)(ing) ------> compute diff. [jump]
  

To find the root of a word like "swimming", I then used a levenshtein distance algorithm that would find the closest word.

  E.g. swimming ----> (swimm)(ing) ------> closest root: (swim) ------> compute diff. [swim].
