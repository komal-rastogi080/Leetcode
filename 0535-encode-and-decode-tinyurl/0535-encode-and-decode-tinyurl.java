public class Codec {
    Map<String, String> urls = new HashMap<>(), codes = new HashMap<>();
    String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public String getCode(){
        char[] code = new char[6];
        for(int i=0; i<6; i++){
            code[i] = chars.charAt((int)Math.random()*62);
        }
        return "http://tinyurl.com/"+String.valueOf(code);
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(urls.containsKey(longUrl)) return urls.get(longUrl);
        String c = getCode();
        while(codes.containsKey(c)) c = getCode();
        urls.put(longUrl, c);
        codes.put(c, longUrl);
        return c;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codes.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));