public class BST {
    Node root;

    public void insert(Song song, String songName, String Author){
        if(root==null){
            root = new Node(song, songName, Author);
        }
        else{
            Node temp = root;
            Node p = root;
            while(temp!=null){
                if(songName.compareTo(temp.songName) <0){
                    p=temp;
                    temp=temp.left;
                }
                else{
                    p=temp;
                    temp=temp.right;
                }
            }
            if(p.songName.compareTo(songName) > 0){
                p.left=new Node(song, songName, Author);
            }
            else{
                p.right=new Node(song, songName, Author);
            }
        }
    }

    public void LNR(Node node){

        if(node!=null){
            LNR(node.left);
            System.out.print(node.songName+" by "+node.Author);
            LNR(node.right);
        }
    }


    public void LRN(Node node){

        if(node!=null){
            LRN(node.right);
            System.out.print(node.songName+" by "+node.Author);
            LRN(node.left);
        }

    }

    public Node find(String song){
        if(song.equals(root.songName)) return root;
        else{
            Node temp= root;
            while(temp!=null && !temp.songName.equals(song)){
                if(song.compareTo(temp.songName)<0){
                    temp=temp.left;
                }
                else{
                    temp=temp.right;
                }
            }
            return temp;
        }
    }

    public void deleteNochild(Node t,Node p){
        if(p.right==t){
            p.right=null;
        }
        else{
            p.left=null;
        }
    }

    public void deleteOneChild(Node t, Node  p){
        if(p.right ==t){
            if(t.right!=null){
                p.right = t.right;
            }
            else{
                p.right=t.left;
            }
        }
        else{
            if(t.right!=null){
                p.left = t.right;
            }
            else{
                p.left=t.left;
            }
        }
    }

    public void Delete(String song){
        Node temp = root;
        Node p=temp;
        if(temp==null){
            System.out.println("Tree is empty");
        }
        else{
            while(temp!=null && !song.equals(temp.songName)){
                if(song.compareTo(temp.songName)<0){
                    p=temp;
                    temp=temp.left;
                }
                else{
                    p=temp;
                    temp=temp.right;
                }
            }
            if(temp.right==null&&temp.left==null){
                deleteNochild(temp,p);
            }
            else if((temp.left!=null&&temp.right==null)||(temp.left==null&&temp.right!=null) ){
                deleteOneChild(temp,p);
            }
            else{
                Node current = temp.right;
                p = temp.right;
                while(current.left!=null){
                    p = current;
                    current = current.left;
                }
                temp.songName.equals(current.songName);
                if (current.right == null){
                    deleteNochild(current, p);
                }
                else {
                    deleteOneChild(current, p);
                }
            }
        }
    }

}