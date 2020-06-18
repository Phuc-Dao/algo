"""
For problems relating to multiple cases, immediately draw out the cases.

Pro tip: Use every given constraint in the problem, in this exmple one of the constraints/properties
was that they only gave you two cornes to the rectangle. These two points determines where the rectangloe begins and ends
There are only 4 possible cases


"""
class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        return not (rec2[1] >= rec1[3] or # The bottom left corner of rec2 is to the top of rec 1
                    rec2[0] >= rec1[2] or # The bottom left corner of rec2 is the the right of rec 1
                    rec2[2] <= rec1[0] or # The top right corner of rec2 is to the left of rec 1
                    rec2[3] <= rec1[1]) # The bottom right of rec 2 is underneath rec 1