function queue(size){
    this.size = 0;
    this.collection = [];
    this.push = function(value){
        if(this.size == size){
            return "Overflow Occured";
        }
        this.collection.push(value)
        this.size++;
        return "Succesfully Instered";
    }
    this.pop = function(){
        if(this.size == 0){
            return "UnderFlow Occured";
        }
        this.collection.pop();
        this.size--;
        return "Succesfully Deleted";
    }
}