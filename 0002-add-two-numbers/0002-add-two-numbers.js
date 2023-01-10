  function ListNode(val, next) {
      this.val = (val===undefined ? 0 : val)
      this.next = (next===undefined ? null : next)
  }
  /*
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function (l1, l2) {
    let over = 0;
    const recursive = () =>{
        if(l1 === null && l2 === null){
            if(over === 1){
                return new ListNode(1, null);
            }
            return null;
        }

        let sum = over;
        if(l1 !== null){
            sum += l1.val; 
            l1 = l1.next;
        }
        if(l2 !== null){
            sum += l2.val;
            l2 = l2.next;
        }
        if(sum >=10){
            over = 1;
        }else{
            over = 0; 
        }

        return new ListNode(sum % 10, recursive())
    }
    return recursive();
};