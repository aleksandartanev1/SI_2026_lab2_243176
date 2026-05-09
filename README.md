SI_2026_lab2_243176
Aleksandar Tanev 243176

Testiranje:
>>>>Every statement za searchBookByTitle
test case 1:
List<Book> result1 = library.searchBookByTitle("Java");
        assertNotNull(result1);
        assertEquals(1, result1.size());
se prebaruva kniga shto postoi i ne e pozajmena, ocekuvan rezultat e lista so edna kniga
pokrieno:
kreiranje lista results
for loop
proverka na uslov
dodavanje kniga vo results
vrakanje lista

test case 2:
        List<Book> result2 = library.searchBookByTitle("C++");
        assertNull(result2);
se prebaruva kniga shto ne postoi, se ochekuva null
pokrieno:
for loop
uslov FALSE
results.isEmpty()
return null

test case 3:
        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });
se prebaruva prazen naslov, ocekuvano da se frli exception
pokrieno:
proverka title.isEmpty()
throw exception


>>>>>Every Branch za borrowBook
test case 1:
library.addBook(new Book("Java", "Marko", "Programming"));
library.borrowBook("Java", "Marko");
  knigata uspeshno se pozajmuva
pokrieno:
title.isEmpty() || author.isEmpty()  FALSE
title/author match  TRUE
!book.isBorrowed()  TRUE

test case 2:
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Java", "Marko");
        });
knigata e vekje pozajmena i se ochekuva exception
pokrieno:
prv if  FALSE
vtor if  TRUE
!book.isBorrowed() → FALSE

test case 3:
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Python", "Ana");
        });
knigata ne e najdena i se ochekuva exception
pokrieno:
prv if  FALSE
vtor if  FALSE

test case 4:
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Marko");
        });
nevaliden input i se ochekuva exception
pokrieno:
prv if TRUE


>>>>>Multiple condition za searchBookByTitle
test case 1:
Book b1 = new Book("Java", "Marko", "Programming"); TRUE TRUE postoi, ne e pozajmena
test case 2:
Book b2 = new Book("Java", "Ana", "Programming"); TRUE FALSE postoi, pozajmena e
test case 3:
Book b3 = new Book("Python", "Ana", "Programming"); FALSE TRUE ne postoi, ne e pozajmena
test case 4:
Book b4 = new Book("C++", "Ivan", "Programming"); FALSE FALSE ne postoi, pozajmena e



>>>>>Multiple condition za borrowBook
test case 1:
 library.borrowBook("", ""); TRUE TRUE naslov prazen avtor prazen
test case 2:
library.borrowBook("", "Marko"); TRUE FALSE naslov prazen avtor
test case 3:
library.borrowBook("Java", ""); FALSE TRUE naslov avtor prazen
test case 4:
library.borrowBook("Java", "Aleksandar"); FALSE FALSE naslov avtor


Minimalen broj test sluchai:

Every Statement za searchBookByTitle: 3
Every Branch za borrowBook: 4
Multiple Condition searchBookByTitle: 4
Multiple Condition borrowBook: 4

CFG za borrow book
<img width="641" height="941" alt="borrowbook-243176" src="https://github.com/aleksandartanev1/SI_2026_lab2_243176/blob/master/borrowbook-243176.png" />

CFG za searchbook
<img width="463" height="991" alt="searchbookbytitle-243176" src="https://github.com/aleksandartanev1/SI_2026_lab2_243176/blob/master/searchbookbytitle-243176.png" />



