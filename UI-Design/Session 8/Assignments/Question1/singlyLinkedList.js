function LinkedList() {
    this.head = null;
    this.tail = null;
  }
  
  function Node(value, next) {
    this.value = value;
    this.next = next;
  }
  
  LinkedList.prototype.addToHead = function(value) {
    var newNode = new Node(value, this.head);
    if(!this.head)
    {
        this.tail = newNode;
    }
    this.head = newNode;
  };
  
  LinkedList.prototype.addToTail = function(value) {
    var newNode = new Node(value, null);
    if (this.tail) {
      this.tail.next = newNode;
    } else {
      this.head = newNode;
    }
    this.tail = newNode;
  };
  
  LinkedList.prototype.removeHead = function() {
    if (!this.head) {
      return null;
    }
    var val = this.head.value;
    this.head = this.head.next;
    if (!this.head) {
      this.tail = null;
    }
    return val;
  };
  
  LinkedList.prototype.removeTail = function() {
    if (!this.tail) {
      return null;
    }
    var val = this.tail.value;
    var currentNode = this.head;
    var tailPrev = null;
    while(currentNode.next)
    {
        if(currentNode.next.next == null)
        {
            tailPrev = currentNode;
        }
        currentNode = currentNode.next;
    }

    this.tail = tailPrev;
    if (this.tail) {
      this.tail.next = null;
    } else {
      this.head = null;
    }
    return val;
  };
  
  LinkedList.prototype.search = function(searchValue) {
    var currentNode = this.head;
    while (currentNode) {
      if (currentNode.value == searchValue) {
        return currentNode.value;
      }
      currentNode = currentNode.next;
    }
    return null;
  };
  
  LinkedList.prototype.indexOf = function(value) {
    var indexes = [];
    var currentIndex = 0;
    var currentNode = this.head;
    while (currentNode) {
      if (currentNode.value == value) {
        indexes.push(currentIndex);
      }
      currentNode = currentNode.next;
      currentIndex++;
    }
    return indexes;
  };
  
  LinkedList.prototype.addAtLocation = function(value, location) {
      if(location == 1)
      {
          this.addToHead(value);
          return 1;
      }
      var newNode = new Node(value,null);
      var index = 2;
      var currentNode = this.head.next;
      var prevNode = this.head;
      while(currentNode)
      {
          if(index == location)
          {
              prevNode.next = newNode;
              newNode.next = currentNode;
              return 1;
          }
          prevNode = currentNode;
          currentNode = currentNode.next;
          index++;
      }
      return -1;
  };
  
  LinkedList.prototype.removeAtLocation = function(location) {
      if(location == 1)
      {
          this.removeHead();
          return 1;
      }
      var index = 2;
      var currentNode = this.head.next;
      var prevNode = this.head;
      while(currentNode)
      {
          if(index == location)
          {
              if(!currentNode.next)
              {
                  this.removeHead();
                  return 1;
              }
              
              prevNode.next = currentNode.next;
              return 1;
          }
          prevNode = currentNode;
          currentNode = currentNode.next;
          index++;
      }
      return -1;
  };
  
LinkedList.prototype.addAfterValue = function(value){
    var indexes = this.indexOf(value);
    if(!indexes)
    {
        location = indexes[0] + 1;
        this.addAtLocation(value,location);
        return 1;
    }
    return -1;
}
  
  var mylnk = new LinkedList();
  
  mylnk.addToHead(5);
  mylnk.addToHead(6);
  mylnk.addToHead(7);
  mylnk.addToHead(8);
  mylnk.addToHead(9);
  
  mylnk.addAtLocation(3,2);
