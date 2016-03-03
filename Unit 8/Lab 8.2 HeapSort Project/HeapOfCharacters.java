//Listing 10.7
//********************************************************************
//  HeapOfCharacters.java       Author: Lewis/Loftus/Cocking
//
//  Implements a heap of characters.
//********************************************************************

import java.util.ArrayList;

public class HeapOfCharacters
{
   private ArrayList<Character> heap;

   //-----------------------------------------------------------------
   //  Sets up an empty heap.
   //-----------------------------------------------------------------
   public HeapOfCharacters ()
   {
      heap = new ArrayList<Character>();
      heap.add(null); // add a "dummy" element in position 0
   }

   //-----------------------------------------------------------------
   //  Returns a string representing this heap.
   //-----------------------------------------------------------------
   public String toString ()
   {
      return heap.toString();
   }

   //-----------------------------------------------------------------
   //  Adds an element to the heap.
   //-----------------------------------------------------------------
   public void add (Character ch)
   {
      heap.add(ch);
      bubbleUp();
   }

   //-----------------------------------------------------------------
   //  Bubbles the last element up as necessary to preserve
   //  the ordering of the heap.
   //-----------------------------------------------------------------
   private void bubbleUp ()
   {
      int curIndex = heap.size() - 1;
      int parentIndex = curIndex / 2;
      Character cur = heap.get(curIndex);

      while ((curIndex > 1) &&
             (cur.compareTo(heap.get(parentIndex)) < 0))
      {
         // Swap current element with its parent
         Character parent = heap.get(parentIndex);
         heap.set(parentIndex, cur);
         heap.set(curIndex, parent);

         curIndex = parentIndex;
         parentIndex = curIndex / 2;
      }
   }
   
   
   // bubbles down a root to preserve ordering of the heap
   private void bubbleDown()
   {
       int curIndex = 1;
       int childIndex1 = curIndex*2;
       int childIndex2 = curIndex*2 + 1;
       
       Character cur = heap.get(curIndex);
       
       
       while (curIndex*2 < heap.size()-1 && (cur.compareTo(heap.get(childIndex1)) > 0
       || cur.compareTo(heap.get(childIndex2)) > 0))
       {
           Character child1 = heap.get(childIndex1);
           Character child2 = heap.get(childIndex2);
           if (child1.compareTo(child2) < 0)
           {
               
               
               heap.set(curIndex,child1);
               heap.set(childIndex1,cur);
               curIndex = childIndex1;
               childIndex1 = curIndex*2;
               childIndex2 = curIndex*2+1;
               
           }
           else
           {
               
               heap.set(curIndex,child2);
               heap.set(childIndex2,cur);
               curIndex = childIndex2;
               childIndex1 = curIndex*2;
               childIndex2 = curIndex*2+1;
               
           }
           
       }
   }
   
   
   // Removes the root of the heap
   
   public Character removeRoot()
   {
       int curIndex = heap.size() -1;
       
       if (heap.size() == 2)
       {
           Character root = heap.remove(curIndex);
           return root;
       }
       else
       {
           Character root = heap.set(1,heap.get(curIndex));
           bubbleDown();
           heap.remove(curIndex);
           
           return root;
       }
      

       
       
       
       
       
       
       
   }
} 