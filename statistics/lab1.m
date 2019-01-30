%U1
%X=['v','w','x','y','z'];
%Str=perms(X)
%S=size(Str)
%disp('Anzahl Strings:')
%S(1)
%S(2)

%U2

 %randi(49,10,6)
 
 %U3
 
  %Aruncaturi=randi(6,100,2)
  
  %ct=0
  %for i=1:100
  %  if Aruncaturi(i,1)==1 && Aruncaturi(i,2)==1
  %    ct=ct+1
  %   endif
  %endfor
  
  %Probabilitate = ct/length(Aruncaturi)
  
  %U4
  clear all;
  v=['w','x','y','z'];
 ind=1;
  for i=1:4
    for j=1:4
      for k=1:4
        str(ind,1:3) = [v(i),v(j),v(k)];
        ind = ind+1;
      endfor
    endfor
  endfor
  
  length(str)