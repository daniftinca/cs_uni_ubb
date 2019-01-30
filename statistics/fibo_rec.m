
function a=fibo_rec(n)
  
  if(n==0)
    a=0;
  elseif(n==1)
    a=1;
  else
    a=fibo_rec(n-1)+fibo_rec(n-2);
  end
end