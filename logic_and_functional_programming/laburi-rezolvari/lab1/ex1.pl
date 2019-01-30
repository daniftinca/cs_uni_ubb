direct(frankfurt,san_francisco).
direct(frankfurt,chicago).
direct(san_francisco,honolulu).
direct(honolulu,maui).

connection(X, Y) :- direct(X, Y).
connection(X, Y) :- direct(X, Z), connection(Z, Y).

add(X,0,X). % x + 0 = x
add(X,s(Y),s(Z)) :- add(X,Y,Z). % x + y = z x + s(y) = s(z)


mul(X,0,0). %x*0 = 0
%mul(X,s(0),X). %x*1=x.
%mul(X,s(s(0)),Z):-add(X,X,Z). %x*2 = Z adica x+x=Z
%add(mul(X,Y,T),X,Z)
mul(X,s(Y),Z):-mul(X,Y,T),add(T,X,Z).


fact(0,s(0)).
fact(s(0),s(0)).
fact(s(s(0)),T):-mul(s(0),s(s(0)),T).
fact(s(Y),Rez):-fact(Y,Z),mul(Z,s(Y),Rez).

