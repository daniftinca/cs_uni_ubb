add(0,X,X).
add(X,Y,Z):- X1 is X-1, add(X1,Y,Z1), Z1 is Z+1.

add2(0,Y,Y).
add2(s(X),Y,s(Z)):- add2(X,Y,Z).
