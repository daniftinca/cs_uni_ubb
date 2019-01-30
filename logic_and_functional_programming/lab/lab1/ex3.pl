add(X,0,X). % x + 0 = x
add(X,s(Y),s(Z)) :- add(X,Y,Z). % x + y = z x + s(y) = s(z)


mul(X,1,X). %x*1=x
mul(X,s(Y),s(Z)) =
