%A1. Man generiere alle Strings der Länge 5, welche die Buchstaben (ohne
%Wiederholung) v,w,x,y,z enthalten. Wie viele solche Strings gibt es?


X=['v','w','x','y','z'];
Str=perms(X);
S=size(Str);
disp('Anzahl Strings:')
S(1)
