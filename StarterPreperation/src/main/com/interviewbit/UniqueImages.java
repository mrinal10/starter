package com.interviewbit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueImages {
	public static class Image {
        private String filename;
        private int width;
        private int height;
        public Image(String filename, int width, int height) {
            this.filename = filename;
            this.width = width;
            this.height = height;
        }
        /**
         * Two Images are considered equal if they have
         * the same filename (without the extension), and the
         * same number of pixels.
         * Thus, flag.jpg with width=60 height=40 is
         * equal to flag.gif with width=40 and height=60
         */
        public boolean equals(Object other) {
        	//added a check or else it can lead to
        	// nullpointerException
        	if(other == null){
        		return false;
        	}
            Image o = (Image)other;
            if (filename == null || o.filename == null)
                return false;
            String[] components = filename.split("\\.");
            String[] ocomponents = o.filename.split("\\.");
            return components[0].equals(ocomponents[0]) && 
                width * height == o.width * o.height;
        }
        
        public String toString() {
            return "Image: filename=" + filename + " Size=" + width*height;
        }
    }
	
    /** Added Code Block **/
	/**
	 * Couldn't find any bugs as such, But the code 
	 * is not printing "the number of unique images"
	 * added this new method to do the same. 
	 * 
	 * @param images 
	 * @return uniqueImage Set
	 */
	public static Set<Image> getUniqueImages(Image[] images){
    	Set<Image> uniqueImageSet = new HashSet<>();
    	for(Image curImage : images){
    		if (uniqueImageSet.isEmpty()) {
				uniqueImageSet.add(curImage);
			}else{
				boolean  flag = true;
				for(Image preImage : uniqueImageSet){
					if(curImage.equals(preImage)){
						flag = false;
						break;
					}
				}
				if(flag){
					uniqueImageSet.add(curImage);
				}
			}
    	}
    	return uniqueImageSet;
    }
	/****************************/
	
    public static void printImages(Set<Image> images) {
        for(Image image: images) {
            System.out.println(image);
        }
    }

    public static void main(String[] args) {
        Image[] images = {new Image("", 40, 60), 
        				  new Image("", 240, 60), 
        				  new Image("flag.jpg", 40, 60),
                          new Image("flag.gif", 40, 60),
                          new Image("smile.gif", 100, 200),
                          new Image("smile.gif", 50, 400),
                          new Image("other.jpg", 40, 60),
                          new Image("lenna.jpg", 512, 512),
                          new Image("Lenna.jpg", 512, 512)};
        /** Added Code Block **/
        Set<Image> uniqueImageSet = UniqueImages.getUniqueImages(images);
        System.out.println(uniqueImageSet.size());
        printImages(uniqueImageSet);
        System.out.println("---------------");
        /** ----------- **/
        Set<Image> set = new HashSet<Image>(Arrays.asList(images));
        printImages(set);
        
        
    }
}
