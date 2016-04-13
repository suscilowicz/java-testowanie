Scenario : Dodanie 2 tych samych wartosci (wyrzuca exception)

Given a new hash table
When add x by 13
Then hash value is 0
Then add the same value throw exception