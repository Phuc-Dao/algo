class Solution:
    """
    406. Queue reconstruction by height.
    The idea is that if we process the the shortest elem (h,k), then we know there are k things in front of it
    that are equal to or greater than h. 
    """
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # Sort the people by height
        sorted_heights = sorted(people, key = lambda x : x[0])
        # Result object
        res = [None for i in range(len(people))]
        for person in sorted_heights:
            height, spaces = person
            count, index = 0, 0
            # Count the number of Nones and elems with equal height
            while count != spaces:
                if res[index] == None or res[index][0] == height:
                    count += 1
                index += 1
            # We need this in case we land on a non-None index so we look for the first abailable
            while res[index] != None:
                index += 1
            res[index] = [height, spaces]
        return res
    """
    Alternative approach: We can guess to start greedy and process the the largest elements first. Then we have to count the number of elems that are taller than or equal to it that are currently in res and append it right after that element.
    ----------------------
    processing [7,0]
    curr_res = []
    0 elems in front that are taller so place it at begging
    -----------------------
    processing [7,1]
    curr_res = [[7,0]]
    [7,0] is 1 element so place it right after there
    -----------------------
    processsing [6,1]
    curr_res = [[7,0],[7,1]]
    [6,1] goes right after 7,0 
    -----------------------
    processing [5,0]
    curr_res = [[7,0],[6,1],[7,1]]
    """
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        sorted_people = sorted(people, key = lambda x: [-x[0],x[1]])
        res = []
        for p in sorted_people:
            # Magic sauce. If the index does not exist it will append, otherwise it will push everything down
            # Takes O(n) time to in worst case
            res.insert(p[1], p)
        return res