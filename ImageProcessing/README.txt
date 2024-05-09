The ImageProcessingModel interface exists to offer functionality for loading images into the program, manipulating images, storing them, and saving them to one's computer. More specifically, and ImageProcessingModel can load an image and store it, flip an image horizontally, or vertically, it can create greyscale versions of the red channel, green channel, blue channel, value component, intensity component, and luma component of an image, store images after manipulating them, and save those images to the computer.

The ImageProcessingModelImpl class exists as an implementation of the ImageProcessingModel interface that can be instantiated and used. This class utilizes color functions to perform operations to load, manipulate, and store ppm files.

The color function interface exists to abstract out the functionality of each image-manipulating method of an ImageProcessingModel. The apply method of a color function takes in an x position, a y position, and an image, and performs an operation on the pixel at the given x,y position on the image, and returns a new color after performing said operation.

The BlueChannelFunction class exists to return a greyscale version of the blue channel of the pixel at the given x,y position on the given image. 

The ChangeBrightnessFunction class exists to return a different-brightness version of the pixel at the given x,y position on the given image by increasing or decreasing the red, green, and blue channels by a positive constant. Mostly used to either Darken an Image or Brighten it.

The FlipHorizontalFunction class exists to return the pixel horizontally opposite to the pixel at the given x,y position on the given image. 

The FlipVerticalFunction class exists to return the pixel vertically opposite to the pixel at the given x,y position on the given image. 

The GreenChannelFunction class exists to return a greyscale version of the green channel of the pixel at the given x,y position on the given image. 

The IntensityComponentFunction class exists to return a greyscale version of the intensity component of the pixel at the given x,y position on the given image. 

The LumaComponentFunction class exists to return a greyscale version of the luma component of the pixel at the given x,y position on the given image. 

The RedChannelFunction class exists to return a greyscale version of the red channel of the pixel at the given x,y position on the given image. 

The ValueComponentFunction class exists to return a greyscale version of the value component of the pixel at the given x,y position on the given image. 

The ImageProcessingView interface exists to provide methods for viewing messages sent by an ImageProcessingModel, or a controller.

The ImageProcessingTextView class allows for viewing messages sent by the controller, particularly for viewing error messages when a command was typed incorrectly.

The ImageProcessingController interface exists to provide a means of controlling an ImageProcessingModel. This utilizes the ImageProcessing commands to perform operations requested by a client/user.

The ImageProcessingControllerImpl class in an implementation of the ImageProcessingController interface that allows for text input to be used to call commands and manipulate an ImageProcessingModel.

The ImageProcessingCommands interface exists to abstract out the process of executing a method of an ImageProcessingModel to provide for more modularity in terms of what commands are available to the controller. The operations provided by these commands utilize a provided model's color function operations.

The AbstractIPCommand class is an abstract class meant to abstract out the fields shared by every Command used by the controller.

The BlueChannelCommand class exists to manipulate an Image by deriving the Blue Channel from it as the command saves the Image to the model under the given name and saves a version of the image after it the Blue channel operation has been performed.

The RedChannelCommand class exists to manipulate an Image by deriving the Red Channel from it as the command saves the Image to the model under the given name and saves a version of the image after it the Red channel operation has been performed.

The GreenChannelCommand class exists to manipulate an Image by deriving the Green Channel from it as the command saves the Image to the model under the given name and saves a version of the image after it the Green channel operation has been performed.

The FlipHorizontalCommand class exists to manipulate an Image by flipping it horizontally as the command saves the Image to the model under the given name and saves a version of the image after flip operation has been performed.

The FlipVerticalCommand class exists to manipulate an Image by vertically flipping the image as the command saves the Image to the model under the given name and saves a version of the image afterit has been flipped. 

The IntensityComponentCommand class exists to manipulate an Image by deriving the Intensity component from it as the command saves the Image to the model under the given name and saves a version of the image after it the Intensity command has been performed.

The LumaComponentCommand class exists to manipulate an Image by deriving the Luma component from it as the command saves the Image to the model under the given name and saves a version of the image after it the Luma command has been performed.

The ValueComponentCommand class exists to manipulate an Image by deriving the Value components from it as the command saves the Image to the model under the given name and saves a version of the image after it the Value command has been performed.

The SaveImageCommand class exists to save an Image with the given name to a specified path.

The LoadImageCommand class serves to load a provided image and refer to it as its new name henceforth in the program.

Every image in the res/ directory was created by us, and belongs to us, and we authorize their use in this project.

If one desires to manually input commands into the controller, provide no command line arguments. However, to run the preset series of commands, provide "script.txt" as a command line argument. This will load src/Koala.ppm, brighten it by 50, flip it horizontally and vertically, get the value component of it, then save the final result to res/Koala.ppm.

The only changes made to previous code were making the private Map knownCommands in the controller protected, the private Map images in the model protected, and the model throwing an exception if a file that does not exist tries to be loaded. All other previous code remained unchanged.

The BetterImageProcessingModel interface exists to provide additional functionality for loading, modifying, and saving images. It supports various file types, not just ppms, and adds the ability to blur, sharpen, greyscale, and sepia images. 

The BetterImageProcessingModelImpl class exists as an implementation of the BetterImageProcessingModel interface that can be instantiated and used. This class utilizes color functions to perform operations to load, manipulate, and store various files types such as pngs and jpegs.

The BetterImageProcessingController class exists to allow the user to utilize the new functionality offered by a BetterImageProcessingModel. This utilizes the ImageProcessing commands to perform operations requested by a client/user.

The ColorTransformation class exists to abstract the computation used to modify a pixel based on its own color.

The Filter class exists to abstract the computation used to modify a pixel based on the pixels around it.

The GreyscaleFunction class exists to greyscale each pixel of an image.

The SepiaFunction class exists to obtain the sepia tone of each pixel of an image.

The SharpenFunction class exists to sharpen each pixel of an image by accentuating the edges.

The BlurFunction class exists to blur each pixel of an image based on the pixels around it.

The GreyscaleCommand class exists to greyscale an image with the given name, and refer to it henceforth in the program by the given destination name.

The SepiaCommand class exists to sepia an image with the given name, and refer to it henceforth in the program by the given destination name.

The SharpenCommand class exists to sharpen an image with the given name, and refer to it henceforth in the program by the given destination name.

The BlurCommand class exists to blur an image with the given name, and refer to it henceforth in the program by the given destination name.

The BetterLoadCommand class exists to add the ability to load more types of files than just ppms. It loads an image at the given filepath and refers to it henceforth in the program by the given name.

The BetterSaveImageCommand class exists add the ability to save more types of files than just ppms. It saves an Image with the given name to a specified path.

The ImageProcessingGUIView interface exists to provide functionality of a graphical user interface for loading, processing, and saving images. 

The ImageProcessingGUIViewImpl class exists to implement ImageProcessingGUIView. It provides a GUI view for an image processing program that can be instantiated and used. It is used by an ImageProcessingGUIController to display the program and the operations it supports.

The ImageHistogramPanel class exists to display a histogram for the red component, green component, blue component, and value component of an image in a JPanel. It is used by an ImageProcessingGUIViewImpl to display the histogram for the image that is currently being viewed and operated on in the program. 

The ImageProcessingGUIController class exists to allow the client to use a GUI provided by the ImageProcessingGUIView to load, process, and save image by using the BetterImageProcessingModel provided to it. 