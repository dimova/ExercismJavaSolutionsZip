class PrimeCalculator {

    int nth(int nth) {
    	if(nth<1) 
    		throw new IllegalArgumentException();
    	
    	int[] primes = new int[nth];
    	primes[0]=2;
        int num = 3;
    	int i = 1;
    	
        while(i<nth)
    	{
    		boolean prime=true;
    		for(int j = 0; j<i && prime && primes[j]*primes[j]<=num; j++)
    			if(num%primes[j]==0 ) 
    				prime=false;
    			
    		if(prime) 
    			primes[i++]=num;

    		num+=2;
    	}
    	return primes[nth-1];
    }

}
