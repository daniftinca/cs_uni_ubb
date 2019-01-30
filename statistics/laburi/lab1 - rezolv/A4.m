Buchstaben = ['w','x','y','z'];
ct = 0;
for i=1:4
  for j=1:4
    for k=1:4
      perm = strcat(Buchstaben(i),Buchstaben(j),Buchstaben(k))
      ct = ct+1;
    endfor
  endfor
endfor

ct