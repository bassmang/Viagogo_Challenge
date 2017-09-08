# Viagogo_Challenge
For this project I assumed the following:
1) If the input from the user was not valid, then I should show some error message, and let the user type in another response.  I also allowed the user to type values outside the range, which could model a search from a differnce city for example.
2) The price of each ticket could be a double value which was not rounded to 2 decimal places, but was later printed as such.  This was to allow for the most possible accuracy.
3) There could be at most 1000 events because the format I was given only allows for this many (ie 000,001,...,999).
4) The random event generation would create at most 400 events, because the 20 x 20 grid only allows for that many.
5) The maximum price for a ticket was $1000.00 and the minimum was $.01
6) That there should not be an error if there are less than 5 events, rather it should just print as many as possible.
