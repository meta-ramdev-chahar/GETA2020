function removeConsecutiveRepeatedString(string){
    console.log(string);
    for(i = 0; i < string.length -1; i++){
        if(string[i] == string[i+1]){
            j = i + 1;
            while(string[i] == string[j]){
                j++;
            }
            string  = removeConsecutiveRepeatedString(string.slice(0,i) + string.slice(j,string.length));
            return string;
        }
    }
    return string;
}