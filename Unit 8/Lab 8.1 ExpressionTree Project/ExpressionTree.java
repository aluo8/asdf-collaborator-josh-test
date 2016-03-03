/**
 * The class creates a binary tree that represents an arithmetic expression
 * of ints with operators +,-,*,/ and %.
 */
public class ExpressionTree
{
    ExpressionNode root;
    ExpressionTree(String s)
    {
        root = build(s);
    }

    //-----------------------------------------------------------------
    // Returns an int representing the value of the expression 
    // stored in this tree.
    //-----------------------------------------------------------------
    
    public int EvaluateTree()
    {
        
        return root.getExprValue();
        
        
    }
    
    //-----------------------------------------------------------------
    // Helper method for the constructor.
    //-----------------------------------------------------------------
    private ExpressionNode build(String s)
    {
        ExpressionNode current;
        int index = -1;
        
        if (s.lastIndexOf("-") > index || s.lastIndexOf("+") > index)
        {
            
            if (s.lastIndexOf("+") > s.lastIndexOf("-"))
            {
                index = s.lastIndexOf("+");
                current =  new ExpressionNode(s.substring(index,index+1),build(s.substring(0,index)),build(s.substring(index+1,s.length())));
                return current;
            }
            
            else
            {
                index = s.lastIndexOf("-");
                current =  new ExpressionNode(s.substring(index,index+1),build(s.substring(0,index)),build(s.substring(index+1,s.length())));
                return current;
            }
            
        }
        
        else if (s.lastIndexOf("*") > index || s.lastIndexOf("/") > index|| s.lastIndexOf("%") > index)
        {
            if (s.lastIndexOf("*") > s.lastIndexOf("%") && s.lastIndexOf("*") > s.lastIndexOf("/"))
            {
                index = s.lastIndexOf("*");
                current =  new ExpressionNode(s.substring(index,index+1),build(s.substring(0,index)),build(s.substring(index+1,s.length())));
                return current;
            }
            else if (s.lastIndexOf("/") > s.lastIndexOf("%"))
            {
                index = s.lastIndexOf("/");
                current =  new ExpressionNode(s.substring(index,index+1),build(s.substring(0,index)),build(s.substring(index+1,s.length())));
                return current;
            }
            else
            {
                index = s.lastIndexOf("%");
                current =  new ExpressionNode(s.substring(index,index+1),build(s.substring(0,index)),build(s.substring(index+1,s.length())));
                return current;
            }
        }
        else
        {
            return new ExpressionNode(s,null,null);
        }
        
        
        
    }

}
