Scenario : Dodanie zlego rozmiaru tablicy oraz przepelnienie tablicy haszujacej wyrzuca exception 

Given incorrect modulo 2 for table
Given incorrect modulo 3 for table
Given incorrect modulo 5 for table
Given incorrect modulo 7 for table
Given incorrect modulo 11 for table
Given incorrect modulo 1 for table

Given full hash table
Then add new value throw exception
