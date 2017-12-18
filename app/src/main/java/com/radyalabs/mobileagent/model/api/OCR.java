package com.radyalabs.mobileagent.model.api;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by RadyaLabs PC on 13/12/2017.
 */
@NoArgsConstructor
@Data
public class OCR {


    /**
     * language : fi
     * textAngle : 0
     * orientation : Up
     * regions : [{"boundingBox":"164,160,179,220","lines":[{"boundingBox":"164,160,53,23","words":[{"boundingBox":"164,160,53,23","text":"NIK"}]},{"boundingBox":"167,214,176,25","words":[{"boundingBox":"167,215,118,24","text":"Tempat,'Tgl"},{"boundingBox":"288,214,55,20","text":"Lahir"}]},{"boundingBox":"164,239,145,20","words":[{"boundingBox":"164,240,57,19","text":"Jenis"},{"boundingBox":"226,239,83,19","text":"Kelamin"}]},{"boundingBox":"201,312,83,20","words":[{"boundingBox":"201,312,83,20","text":"RTJRW"}]},{"boundingBox":"204,337,94,19","words":[{"boundingBox":"204,337,94,19","text":"DesaiKei"}]},{"boundingBox":"205,361,112,19","words":[{"boundingBox":"205,361,112,19","text":"Kecamäan"}]}]},{"boundingBox":"359,87,395,292","lines":[{"boundingBox":"489,87,234,27","words":[{"boundingBox":"489,88,149,26","text":"PROVINSI"},{"boundingBox":"648,87,75,26","text":"RIAU"}]},{"boundingBox":"362,157,282,24","words":[{"boundingBox":"362,157,282,24","text":",1471073101880042"}]},{"boundingBox":"359,181,214,23","words":[{"boundingBox":"359,181,7,19","text":"-i"},{"boundingBox":"371,186,60,18","text":"PUJA"},{"boundingBox":"439,184,134,19","text":"PRAMUDYA"}]},{"boundingBox":"361,205,282,29","words":[{"boundingBox":"361,205,158,29","text":"!PEKANBARU,"},{"boundingBox":"525,211,118,21","text":"31-01-1988"}]},{"boundingBox":"508,236,162,19","words":[{"boundingBox":"508,237,43,18","text":"Gol."},{"boundingBox":"626,240,7,14","text":":"},{"boundingBox":"638,236,32,18","text":"0+"}]},{"boundingBox":"407,258,347,23","words":[{"boundingBox":"407,261,125,20","text":"SUDiRMAN"},{"boundingBox":"538,260,43,20","text":"GG,"},{"boundingBox":"588,258,166,23","text":"KELAPAftC.6"}]},{"boundingBox":"363,311,96,19","words":[{"boundingBox":"363,311,96,19","text":":0011001"}]},{"boundingBox":"360,335,152,20","words":[{"boundingBox":"360,335,152,20","text":"-VVONOREJO"}]},{"boundingBox":"363,358,230,21","words":[{"boundingBox":"363,359,144,20","text":":MARPOYAN"},{"boundingBox":"515,358,78,19","text":"DAMAE"}]}]},{"boundingBox":"167,380,544,28","lines":[{"boundingBox":"480,380,231,22","words":[{"boundingBox":"480,382,133,20","text":"StatusKaw\u20224n"},{"boundingBox":"623,380,88,20","text":".\u2022KAWN"}]},{"boundingBox":"167,385,126,23","words":[{"boundingBox":"167,385,74,23","text":"Aganz"},{"boundingBox":"287,389,6,14","text":":"}]}]},{"boundingBox":"167,406,322,76","lines":[{"boundingBox":"168,406,289,26","words":[{"boundingBox":"168,408,100,24","text":"Pekeöaan"},{"boundingBox":"288,413,4,14","text":":"},{"boundingBox":"297,406,160,21","text":"VMFUSWASTA"}]},{"boundingBox":"167,431,322,25","words":[{"boundingBox":"167,433,80,19","text":"Beriaku"},{"boundingBox":"254,433,74,23","text":"Hingga"},{"boundingBox":"363,431,126,19","text":":31-01-2020"}]},{"boundingBox":"168,456,248,26","words":[{"boundingBox":"168,459,141,23","text":"Keærganega"},{"boundingBox":"371,456,45,19","text":"Wtdl"}]}]},{"boundingBox":"672,428,147,147","lines":[{"boundingBox":"672,428,147,20","words":[{"boundingBox":"672,429,47,19","text":"OTA"},{"boundingBox":"725,428,94,19","text":"PEKANB"}]},{"boundingBox":"674,453,144,20","words":[{"boundingBox":"674,453,121,20","text":"KADISDUK"},{"boundingBox":"802,453,16,19","text":"D"}]},{"boundingBox":"687,563,36,12","words":[{"boundingBox":"687,563,36,12","text":"KUO"}]}]},{"boundingBox":"865,426,134,126","lines":[{"boundingBox":"871,426,128,24","words":[{"boundingBox":"871,443,3,7","text":","},{"boundingBox":"882,426,117,20","text":"28-04-2015"}]},{"boundingBox":"874,452,101,19","words":[{"boundingBox":"874,452,101,19","text":"ENCAPIL"}]},{"boundingBox":"865,529,109,23","words":[{"boundingBox":"865,530,55,22","text":".sos,"},{"boundingBox":"927,529,47,19","text":"M.Si"}]}]}]
     */

    private String language;
    private int textAngle;
    private String orientation;
    private List<Regions> regions;

    @NoArgsConstructor
    @Data
    public static class Regions {
        /**
         * boundingBox : 164,160,179,220
         * lines : [{"boundingBox":"164,160,53,23","words":[{"boundingBox":"164,160,53,23","text":"NIK"}]},{"boundingBox":"167,214,176,25","words":[{"boundingBox":"167,215,118,24","text":"Tempat,'Tgl"},{"boundingBox":"288,214,55,20","text":"Lahir"}]},{"boundingBox":"164,239,145,20","words":[{"boundingBox":"164,240,57,19","text":"Jenis"},{"boundingBox":"226,239,83,19","text":"Kelamin"}]},{"boundingBox":"201,312,83,20","words":[{"boundingBox":"201,312,83,20","text":"RTJRW"}]},{"boundingBox":"204,337,94,19","words":[{"boundingBox":"204,337,94,19","text":"DesaiKei"}]},{"boundingBox":"205,361,112,19","words":[{"boundingBox":"205,361,112,19","text":"Kecamäan"}]}]
         */

        private String boundingBox;
        private List<Lines> lines;

        @NoArgsConstructor
        @Data
        public static class Lines {
            /**
             * boundingBox : 164,160,53,23
             * words : [{"boundingBox":"164,160,53,23","text":"NIK"}]
             */

            private String boundingBox;
            private List<Words> words;

            @NoArgsConstructor
            @Data
            public static class Words {
                /**
                 * boundingBox : 164,160,53,23
                 * text : NIK
                 */

                private String boundingBox;
                private String text;
            }
        }
    }
}
