int kthGrammar(int n, int k) {
    if(n ==1){
        return 0;
    }
    int p = kthGrammar(n-1,ceil(k/2.0));
    if(p==1){
        if(k%2==1)
        return 1;
        else
        return 0;
    }
    else{
        if(k%2==1)
        return 0;
        else
        return 1;
    }

}