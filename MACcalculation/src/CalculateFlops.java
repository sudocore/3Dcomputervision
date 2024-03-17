public class CalculateFlops {
    public static void main(String[] args) {
        /* arg[0] = 1 (convolution layer), 2 (fully connected layer), or
            3 (max pooling layer)
            if convolution layer, arg[1] = kernel size (one dimension),
                                  arg[2] = input channel size,
                                  arg[3] = output channel size,
                                  arg[4] = width of output feature map,
                                  arg[5] = height of output feature map
            if fully connected layer, arg[1] = input layer size (number of neurons),
                                      arg[2] = output layer size (number of neurons)
            if maxpool layer, arg[1] = size of kernel (one dimension),
                              arg[2] = width of output feature map,
                              arg[3] = height of output feature map
        */
        System.out.println("Hello world!");

        int layerType = Integer.parseInt(args[0]);
        long numFlops = 0;
        long numMACs = 0;

        switch (layerType) {
            case 1:
                int kernelSize = Integer.parseInt(args[1]);
                int inputChannelSize = Integer.parseInt(args[2]);
                int outputChannelSize = Integer.parseInt(args[3]);
                int widthOutputFeatureMap = Integer.parseInt(args[4]);
                int heightOutputFeatureMap = Integer.parseInt(args[5]);
                numFlops = (long)kernelSize * (long)kernelSize * (long)inputChannelSize * (long)outputChannelSize * (long)widthOutputFeatureMap * (long)heightOutputFeatureMap;
                numMACs = numFlops/2;
                break;

            case 2:
                int inputLayerSize = Integer.parseInt(args[1]);
                int outputLayerSize = Integer.parseInt(args[2]);
                numFlops = (long)inputLayerSize * (long)outputLayerSize;
                numMACs = numFlops/2;
                break;

            case 3:
                numFlops = 0;
                numMACs = numFlops/2;
                break;

            default:
                numFlops = 0;
                numMACs = numFlops/2;
                break;
        }

        // Printing the number of FLOPs and MACs
        System.out.println("Number of FLOPs = " + numFlops + "; Number of MACs = " + numMACs);
    }
}
