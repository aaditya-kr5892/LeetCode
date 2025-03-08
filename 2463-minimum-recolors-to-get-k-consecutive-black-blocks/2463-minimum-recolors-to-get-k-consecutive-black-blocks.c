int minimumRecolors(char* blocks, int k) {
    int l = 0 ;
    int r = k-1;
    int cw = 0; 
    int cb = 0 ;
    int min = 0 ;
    for(int i = l ; i <= r ; i++){
        if(blocks[i] == 'W'){
            cw++;
        }
        else
        cb++;
    }
    min = cw;
    for(int i = r+1 ; i < strlen(blocks) ; i++){
        if(blocks[i] == 'W'){
            cw++;
            if(blocks[l] == 'B')
            cb--;
            else
            cw--;
        }
        else{
            cb++;
            if(blocks[l] == 'W')
            cw--;
            else
            cb--;
        }
        l++;
        if(cb < 0){
            cb = 0 ;
        }
        if(cw < 0){
            cw = 0;
        }
        min = (min < cw)?min:cw;
    }
    return min;
}