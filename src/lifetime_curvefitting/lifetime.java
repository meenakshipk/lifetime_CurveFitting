/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime_curvefitting;

import ij.ImagePlus;
import ij.ImageStack;
import ij.gui.Plot;
import ij.gui.PlotWindow;
import ij.io.FileSaver;
import ij.measure.CurveFitter;
import ij.process.FloatProcessor;
import ij.process.ImageProcessor;
import java.awt.Component;
import java.awt.Image;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Meenakshi P. created on 20191021
 *
 * currently working on writing code to fit data to analytic function. this is
 * NOT the code for uploading a set of images with wxh resolution, performing
 * fitting on each pixel to obtain the lifetime image. *
 */
public class lifetime extends javax.swing.JFrame {

    private Component frame;

    /**
     * Creates new form lifetime
     */
    public lifetime() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldXRes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldYRes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonUploadFile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTimePoints = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabelProgressBar = new javax.swing.JLabel();
        lifetimeImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Image resolution:");

        jTextFieldXRes.setText("28");

        jLabel2.setText("by");

        jTextFieldYRes.setText("24");

        jLabel3.setText("Repetition rate of laser:");

        jTextField3.setText("80");

        jLabel4.setText("MHz");

        jLabel5.setText("Select file:");

        jButtonUploadFile.setText("Upload");
        jButtonUploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUploadFileActionPerformed(evt);
            }
        });

        jButton1.setText("Button : Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Upload text file with xdata, ydata - 14 points");

        jLabel7.setText("No. of files/data points:");

        jTextFieldTimePoints.setText("14");

        jLabelProgressBar.setText("Progress Bar:");

        jLabel8.setText("Output:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTimePoints, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldXRes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldYRes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5)
                    .addComponent(jButtonUploadFile)
                    .addComponent(jButton1)
                    .addComponent(jLabel6)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProgressBar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lifetimeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldXRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldYRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldTimePoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelProgressBar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUploadFile)
                        .addGap(59, 59, 59))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lifetimeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUploadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUploadFileActionPerformed
        //choose multiple files
        JFileChooser Fc = new JFileChooser();
        Fc.showOpenDialog(this);
        File f = Fc.getSelectedFile();

        //for testing - file 14 datapoints
        double[] xdata = new double[14];
        double[] ydata = new double[14];

        //read file and store xdata and ydata
        String dataString = "";
        int c = 0;
        float xData = 0;
        float yData = 0;
        FileReader fReader = null;
        File curFile = f;
        if (curFile.exists()) {

            try {
                fReader = new FileReader(curFile);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(lifetime.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                int count = 0;
                while ((c = fReader.read()) != -1) {
                    switch (c) {
                        case '\t':
                            xData = Float.parseFloat(dataString);
                            xdata[count] = xData;
                            dataString = "";
                            break;
                        case '\n':
                            yData = Float.parseFloat(dataString);
                            ydata[count] = yData;
                            count = count + 1;
                            dataString = "";
                            break;
                        default:
                            dataString += (char) c;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(lifetime.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //find lowest yData to initialise parameter 1 for fitting
        double ydataMin = ydata[0];
        System.out.println("Before loop:" + ydataMin);
        for (int i = 0; i < ydata.length; i++) {
            if (ydata[i] < ydataMin) {
                ydataMin = ydata[i];
            }
        }
        System.out.println("After loop:" + ydataMin);

        //custom fit
        String eq = "y = a*((1+(c*(1-exp(-b*x))))*(1 + (1-exp(-b*x))))";
        CurveFitter cf = new CurveFitter(xdata, ydata); //select data and initialize curve fitter
        double[] initialParams = new double[3]; //initialise parameters for user-fn fit 
        initialParams[0] = ydataMin;
        initialParams[1] = 0.001;
        initialParams[2] = 0.05;
        cf.doCustomFit(eq, initialParams, false); //custom-fit
        double[] para = cf.getParams(); //get fit parameters
        double lifetime = 1 / para[1];
        Plot plot = cf.getPlot();
        PlotWindow show = plot.show();
        System.out.println(Arrays.toString(para)); //print fit parameters        
        System.out.println("Lifetime = " + lifetime + " ps"); //lifetime ydataMin
    }//GEN-LAST:event_jButtonUploadFileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lifetimeImage.setIcon(null);
        jLabelProgressBar.setText("Progress:");
        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        (new taskGenerateLifetimeImage()).execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    private float lifetimeFit(double[] xdata, double[] ydata) {
        //custom fit
        String eq = "y = a*((1+(c*(1-exp(-b*x))))*(1 + (1-exp(-b*x))))";
        CurveFitter cf = new CurveFitter(xdata, ydata); //select data and initialize curve fitter
        double[] initialParams = new double[3]; //initialise parameters for user-fn fit 
        initialParams[0] = 1;
        initialParams[1] = 0.001;
        initialParams[2] = 0.05;
        cf.doCustomFit(eq, initialParams, false); //custom-fit
        double[] para = cf.getParams(); //get fit parameters
        double lifetime = Float.NaN;
        if (para[1] >= 0) {
            lifetime = 1 / para[1]; //calculate lifetime
        }
//      System.out.println(Arrays.toString(para)); //print fit parameters        
//        System.out.println("Lifetime = " + lifetime + " ps");
        return (float) lifetime;
    }

    private class taskGenerateLifetimeImage extends SwingWorker<ImagePlus, Integer> {

        private int dataPoints;
        private int xRes;
        private int yRes;

        @Override
        protected ImagePlus doInBackground() throws Exception {
            dataPoints = Integer.parseInt(jTextFieldTimePoints.getText());
            xRes = Integer.parseInt(jTextFieldXRes.getText());
            yRes = Integer.parseInt(jTextFieldYRes.getText());

            //choose multiple files
            JFileChooser Fc = new JFileChooser();
            Fc.setMultiSelectionEnabled(true);
            Fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int status = Fc.showOpenDialog(lifetime.this);
            if (status == JFileChooser.CANCEL_OPTION) {
                return null;
            }
            File[] dataFiles = Fc.getSelectedFiles();
            File dir = Fc.getSelectedFile();
            if (dataPoints != dataFiles.length) {
                System.out.println("Error! No. of files selected does not match no. of dataPoints");
                dataFiles = null;
                return null;
            }

            //create xdata
//        double[] xdata = new double[dataPoints];
//14 dp
            double[] xdata = {
                171.6,
                204.6,
                270.6,
                336.6,
                402.6,
                435.6,
                468.6,
                534.6,
                600.6,
                732.6,
                798.6,
                1046.1,
                1293.6,
                1788.6
            };

//        //27dp
//        double[] xdata = {
//            0,
//            33.33333,
//            66.66667,
//            100,
//            133.33333,
//            166.66667,
//            200,
//            233.33333,
//            266.66667,
//            300,
//            333.33333,
//            400,
//            466.66667,
//            533.33333,
//            600,
//            666.66667,
//            800,
//            933.33333,
//            1066.66667,
//            1200,
//            1333.33333,
//            1666.66667,
//            2000,
//            2333.33333,
//            2666.66667,
//            3000,
//            3333.33333
//        };
            //create image stack out of selected files
            ImageStack imgStack = new ImageStack(xRes, yRes);
            for (File dataFile : dataFiles) {
                ImagePlus imp = new ImagePlus(dataFile.getAbsolutePath());
                ImageProcessor ip = imp.getProcessor();
                try {
                    imgStack.addSlice(ip);
                } catch (Exception e) {
                    System.out.println("imgStack.addSlice() error: " + e);
                    JOptionPane.showMessageDialog(frame, "Error in creating image stack.", "Error", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
            }
            //initialise lifetimeImage float array
            float[][] lifetimeImg = new float[xRes][yRes];

            //METHOD 3 - 
            //21.404 seconds for 28*24 resoln image i.e. 672 pixels
            //for 1024 * 1024 res i.e. 1048576 - 33398.3939 s i.e. 556.639898 mins i.e. 9.2773h
            for (int y = 0; y < yRes; y++) {
                for (int x = 0; x < xRes; x++) {
                    float[] yArray = new float[1 * 1 * dataPoints];
                    imgStack.getVoxels(x, y, 0, 1, 1, dataPoints, yArray);
//                System.out.println("x: " + x + " y:" + y + " float array: " + Arrays.toString(yArray));
                    double[] ydata = new double[yArray.length];
                    IntStream.range(0, yArray.length).forEach(index -> ydata[index] = yArray[index]);
                    float result = lifetime.this.lifetimeFit(xdata, ydata);
                    lifetimeImg[x][y] = result / 100; //lifetime in ns
                    publish((xRes * y) + x);
                }
            }
            //System.out.println("lifetimeImg array: " + Arrays.deepToString(lifetimeImg));
            //image creation
            ImageProcessor ltIP = new FloatProcessor(xRes, yRes);
            ltIP.setFloatArray(lifetimeImg);
            ImagePlus liIMP = new ImagePlus("Lifetime image", ltIP);
            liIMP.show();
            new FileSaver(liIMP).saveAsTiff(dir.getParent() + File.separator + liIMP.getTitle() + ".tif");
            return liIMP;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            int curValue = chunks.get(chunks.size() - 1);
            int progressValue = curValue * 100 / (xRes * yRes);
//            lifetime.this.jLabelProgressBar.setText("Progress: [Insert custom message here]");
            lifetime.this.jProgressBar1.setValue(progressValue);
        }

        @Override
        protected void done() {
            try {
                Image image = get().getImage();
                if (image != null) {
                    jLabelProgressBar.setText("Progress Bar: Task Completed.");
                    image = image.getScaledInstance(lifetimeImage.getWidth(), lifetimeImage.getHeight(), Image.SCALE_SMOOTH);
                    lifetimeImage.setIcon(new ImageIcon(image));
                }
            } catch (Exception e) {
                System.out.println(e);
                jLabelProgressBar.setText("Progress Bar: Error.");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lifetime.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lifetime.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lifetime.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lifetime.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lifetime().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonUploadFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelProgressBar;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldTimePoints;
    private javax.swing.JTextField jTextFieldXRes;
    private javax.swing.JTextField jTextFieldYRes;
    private javax.swing.JLabel lifetimeImage;
    // End of variables declaration//GEN-END:variables
}
