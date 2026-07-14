class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] arr = path.split("/");
        for(String str : arr){
            if(str.equals(".") || str.isEmpty()) continue;
            else if(str.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(str);
            }
        }
        
        return "/"+String.join("/", st);
    }
}