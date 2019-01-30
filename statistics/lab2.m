%ersten Spiel
fprintf("Problema 1 a")
s1 = randi(6,100,4);


ct = 0;

for i=1:100;
  for j=1:4;
    if s1(i,j) == 6;
      ct = ct+1;
      break;
    endif
  endfor
endfor

p1 = ct/100 * 100;

fprintf('Probabilitat 1: %d /100 \n',p1)

%zweiten Spiel

ctWin=0;
for i=1:100;
  spiel = randi(6,24,2);
  for j=1:24;
    if spiel(j,2) == 6 && spiel(j,1)==6;
      ctWin = ctWin + 1;
      break;
    endif
   endfor
 endfor
p2 = ctWin/100 * 100;

fprintf('Probabilitat 2: %d /100 \n',p2) 



%1 Again
ct11=0;
for i=1:100
  w = randi(6,4,1);
  suma = sum(w==6);
  if suma>=1
    ct11 = ct11+1;
    endif
   endfor

wkt = ct11/100

theorie = 1-(5/6)^4




%2 Again
ct12 = 0;
for i=1:100
  w2 = randi(6,2,24);
  suma2 = sum(w2);
  if sum(suma2==12)>=1;
    ct12 = ct12+1;
  endif
endfor

wkt = ct12/100
theorie = 1 - (35/36)^24



%3
w3 = randi(6,3,1000000);
matrice = tabulate(sum(w3));
aux = max(matrice(:,2));
ind_max = find(matrice(:,2)==aux)

rezerva = find(matrice(:,2)>0);
ind = min(matrice(rezerva,2));

index = find(matrice(:,2)==ind)


matrice(index,3)
matrice(ind_max,3)



