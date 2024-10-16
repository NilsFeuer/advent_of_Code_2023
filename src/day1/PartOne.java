package day1;

/*
* --- Day 1: Trebuchet?! ---
Something is wrong with global snow production, and you've been selected to take a look.
* The Elves have even given you a map; on it,
* they've used stars to mark the top fifty locations that are likely to be having problems.

You've been doing this long enough to know that to restore snow operations,
* you need to check all fifty stars by December 25th.

Collect stars by solving puzzles.
* Two puzzles will be made available on each day in the Advent calendar;
* the second puzzle is unlocked when you complete the first.
* Each puzzle grants one star. Good luck!

You try to ask why they can't just use a weather machine ("not powerful enough") and
* where they're even sending you ("the sky") and
* why your map looks mostly blank ("you sure ask a lot of questions") and
* hang on did you just say the sky ("of course, where do you think snow comes from")
* when you realize that the Elves are already loading you into a trebuchet
* ("please hold still, we need to strap you in").

As they're making the final adjustments,
* they discover that their calibration document (your puzzle input) has been amended by a very young Elf who
* was apparently just excited to show off her art skills.
* Consequently, the Elves are having trouble reading the values on the document.

The newly-improved calibration document consists of lines of text;
* each line originally contained a specific calibration value that the Elves now need to recover.
* On each line, the calibration value can be found by combining the first digit and
* the last digit (in that order) to form a single two-digit number.

For example:

1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

Consider your entire calibration document. What is the sum of all of the calibration values?
* */

public class PartOne {

    public static String input = """
            dssmtmrkonedbbhdhjbf9hq
            2njsevenszzsfltconesixhsflpbpd
            6shgbprkpbksnfourfivemvncvg2eight
            eightseventhree7lfqpnclxnnineninemgkjtqksrdone
            bsxxzhkmmfcslmdhhrgf9seven665lsknmbpgj
            9fourfiveqjv4sxdbpcj77
            24twoonefive
            threesixfiveonefour36nggvfvdkzsix
            zvoneightngnpvvq8mpmsdjmvznrntwo
            fourbdqlr7pdqvhnjfnbrcnd8
            jtdvqdsixkfnmlrxc58
            dgcvchcdmksvqhdqvs29onenddxsqseven
            dqc57tf1xmkdnll
            cndpcrpnssix4fourxmdkreightvtxflcsg6
            5qnnsvrtwo1ninerzmtkdcm8six
            43onegx3ddqrp
            six76hljnssix8
            six4kzjdcbbbhvnineseveneight6sevenfive
            4rx6tpghlcgf
            67mcmfive1sixonefive
            97two19
            six7ninetwosgtrpsqzltmjqkghrgbninexnmbbj
            pvxbdnqlvnx5slshseven748nine
            six9234pg7ninehmvrhxhhrc
            qhzp72twopxttldgmvqthgdnxhvht2nine
            8865zhhzgmzbglrmtdpdrt7
            7874
            fvmzfsck614
            2nine73eight4five
            2threefivengnvkrzmg6two
            21pzrckpscqnineseven
            dpcxmtdhrkjcvxqsrsl7fivehtfljvjh
            4dqhvlfmjfive14
            qzhmmsqfc7
            3kbklxmh
            eightf1mhkbdl4beight4
            k5rbcsrxtgd1vfhzmltqtcgmcmgtdjtxk
            9ldshn2twothreetwocmqjfourfxhb
            fkjpjmtvrz7fcpfmvbmlxn
            xkvzhqj75
            one6rzeight61eightrdxgsdxx4
            htfcnddhsl2d9zgqbdmfzsixtwosix
            ctvrqbrrzg3nine2dhbrmcs
            slcfsjt232fivebmjtdqfivempxzzhmmx
            bxqvkfour3jfkkqttxgsclstjg
            five5fournghbgprmfninephcmfzxksvqfvklrcnqnk
            sixrthreeseven74oneightssl
            gzd2l8seven
            qjvhxbzdp311sixonetwo
            hljdmsjbhclftbzqmtg636229
            9sixkmljpgnc6nbjmpgsstjrzhlsdck
            23slthree36qngbd
            6seventhglqeightcqltbdjxponefive
            preightthreeqk51
            pnhcr27ninesevenbvllhkdxc1
            zxrnhmthree4rlbhkzfl2
            djcz9foursevencrhgsxkkbln
            lmdvnnmjkg4qdcdkseven
            3rfvvnlp9pdjnxkqtv5bnpfzdcv
            cgnjnsnj1kvdlzdjvtjgkptjsevenhmmxxlone
            kzxt29fivejhbddgbncbvdqzeight
            6ninefour
            7nxlv
            fhdftpbb2vqqbtnjrjb8hmfks8
            7bgkfthree
            twozxfknjnrmv99xhddsqrxs
            twogndc12dgcghk
            1cnxptqttrfmr
            45qsmt
            213
            twocsfzd1eight7eightwovm
            pgeighteight9mkhghqzfl2fourtwo
            jone7rblvhhp7
            hszhp3mthqnlvkconesbcjhjpv9vz
            ninenine63four4
            4sqkfqznfrmkgbspmb
            2fourdgqzj
            2one99
            drkmbr98fckdjfivetbsrrrpq8pjdkztlhglr
            6cbrzrndxsevenoneightzzd
            sevengz2dggbt446six2
            8ninezmpbklk8ninedfmzrg
            bpcfzztwo252
            63ninesixhfmd3ddkdrjd2one
            fkhnineninejb4tkhzjj
            9rnjqlpq
            59grlcvfgsvxrt2vfhbj4
            3smcnkjdgmnx
            sevenvrtgzmtkrreight6seven4
            twoseventwo9lsd
            one41tvgttqnm1791szxcjbg
            fourxkslzzbboneseven1
            cxszrgsix8nx
            sixrgbzdccx8three3four4m
            nine5jbvqnmxvmhmfzcmtvq4
            25four5
            seveneightthree9
            twoz94nine6h5zq
            2fourfourcjctlzzbhcqmn84nine
            seven4vgnt
            mxpdsfcngvppjkmbjsmfourqgmnqfclttbg75bpsb
            ntrklveightgdgmjbcdfkckqlpjmthreesix3
            1xx8xhdnmkjttseven
            zzoneight8586two
            9fhrxkn1
            dgh22sevensix
            2zjmxzdskhf
            47five66jklg9
            mdcfiveqhnzb97csf
            fiverzrtglhl442sixthreenblbkgs7
            27
            four61gmkgz
            six3zt76five63
            nfrmmgsix1zqnkt1xqdtxh4
            43onenc95seven7
            5qkfjqntwoone5
            32twofivenineqjbncqnx1two
            lkp4ljxmthree
            lfvtfjhvkmpbtxrfourfn7trfgjchvv4fivesix
            twopcznrsk2qxjjvzcbzjg8
            eight2ztjfxgkz1sixthree57three
            gfhctvvksix855qz1
            six5twovfdpcjpbgntzkp9four
            3seven4five9
            3sdnrjhsvfive7dbllppvfgx9four
            1seven1cktwopzqdnshfsthctvh7four
            fiveninebcjmbrlqjfvqnrpnkvlxmdd4fivepxqrlnine
            jfpvt96three
            seven9one5foureight
            5five6
            eightfourone6fivenineeightxjfzcdftrdlngr
            six1srccrmnqpdljxthreelcxm6
            ztjjxbnphhtpfdhgshmvnine6one27nzvrmpltnine
            frtwonelninethreef8jpbcnmftspone
            zfff655jjjjfkldpffvpk
            82vhsgkghljkvkd
            eightthreethree8
            sevennjlmhthreekzcpnqcfjnxb4fivefive1
            nzrbjttzlgxfrrsq5xzxfive
            three8mvklnseven9
            four46vksr9three4four4
            586
            four43frone
            48sixpqlppsix4
            6xtvvsnhzkchlsl7five7bnhdtwo
            seven9mqkfkff
            6ftv
            ddfg63
            ninetwosevenrlvztsffrz9
            mbrxpsjb12bshdbbkkl712
            6threeseveneightvkqflfp8six3twonebq
            1bdmfshjpnl
            2844sixpvxsvqrzd4sgrbseven
            4p1ninelkhnldgbnnseven8one
            hcdqslfourthreeeight6nine3
            7slfqgxpvbtvrgthjtgmn4ltkone
            bsfkkbbzdz6peightnineeight
            1rzpjjffxpq28qthqtbbfv
            fourtwo8lkfbdvlxbs8tvcm
            eightfoureightsevenhbqtmffnfjlsvdxxfcfbtbxhlzhvt7
            dsspzhdf7sevenpb55
            pfxronenzjlvjzqjqcndbsrsjjslx486xtrr
            35hsqdnine94gch
            74kc7q27
            fourtzhronethreesix285
            hhlqg4two8tcsztwo
            three5ninesevenfivehgbvlkhvvqz
            nineqqcqvbqmxk49pcxpmlqqjpskqkrgnvvnine
            cjmxkq527
            45dxdxvntmxtwolcdcdxmgf8
            gkrrn197jgf6fcldbkqmkssix
            dbzsdcmmk6threetwosevenhxxhmmptjghxzdfive
            grq2threesix7xkgqnp1
            kplsrsblmthreesix6eighteight4hmtn9twonec
            xzx93
            szcsc351
            foursix84sevenqqd
            42four45sqgdkeightzbsprvs
            sevenone47
            bcqjlfbkl353eight
            76j1rcvgglnlm
            dggsztbr7kxkdnxmbg
            twocgqcvgsctwoninecnkmfour9
            vsldbggseven3one
            996nrqrmcszm212
            hrkhqsdddsrzgkkglqxgblfvt8zmpgrdbpbnvsdbcfour54
            95threeeight9tnszp3mpjkpjjr
            5qdp
            qglmnkz9two8
            kh8xsl9dhfkfdlp
            59xrljx3
            twoseven47qhxvscpr2six4eight
            jqvfiveonesevenzbdtdpt9qbnlfour
            1nine23
            threemzxlm1fiveg
            one464sixmncqbb
            mlltlhcx6ghxhmcrn
            64bkkxkrbjbjqcdfgrxqeightkshfrcxp
            98qzpmrgxsmsseven9spdgldvxfmzgqonesix
            zfhzkcbrqh2seven8
            pjxhfsgghd3
            4xxvkzhlkhxvsdfives4
            zgpcdrdxtfzrzmt87five
            2bqdd5twonine
            2sixdrgccvgstc
            ltbfour2jzpkqr
            one21
            19kjrjmrdfcpqdvgjsnine
            one75four
            jdrpfour7
            5vdtdsqfourfive
            stwonefiveeightztc2five
            lbdxblhz96zvlsqzppztwoqjjhdrffv
            dvgrpzbtqg9bxcrzpnxffhhspdn9seven2
            eight5fourone
            7fourthreec
            lggphtsqmgbmfxbkgn77
            8lvjthreetwo
            2bdnscpfour4
            8eightlvc8ndtnf5eightwon
            fivethreenbsz8
            ndlpfslspgdthreefivehbbqseven6sixbtrgmzcm
            seven13four6four7gx7
            lhplnpttwo18qmbxzsqsm
            6fvq5gfhmcnjzl
            91fourninenine4one5
            9sixbbzxffour9twohpvzmqlqhrmbcbfbsl
            46ninesix9plqzsmftmpfpqtn8
            ninemccd4five3qltqljzkz21jmcrj
            fivejvtsvhtdeighthmmeighttwo1
            sevennineonesix8vtqkmqqlone7
            2ninebmmkvzkk47gjk
            fourtwo9qrthree5
            9six6four3
            cmeightwo6lthth1cpclsptwo258
            jmrqtwo1two5
            fourtwo64pmfrftrgpfss2oneeight
            7hrhxq31
            jkk9seven5lkhflxk
            3seven1rdqk9
            two5mvnqbdcgg584
            lbphxlhsntdzr2
            one6threeonefivefvftkmlszl
            5tvgql
            7two33xgjsjkvx5nine6
            jcn7eight
            four435six
            sevencsrtkfmh6
            eightmvgrrqgqftjdk3mrfourthreefivef
            5sixsix53two8
            eighttwo9eightrdcjr
            xrtscrone2jvcdk97flfjm63
            sevenncz7bcqznctsvptfzsct
            ninefkplkdqonedmsrqfjzs8
            two32mmtbggnpxcp7tg25
            sixzeightrsg8vdt8
            eightzqpgjmfour63
            4one2six
            ninexxrqmbj9lmz8htsix
            jkfbz1frmnztcfour9
            zeightwozfsgcsbcjf6nine4five5sthreenine
            6fivesixhfqsbcceighttwo
            4twosix56eightkklcmxn
            fivetwozmhhgs47four1spjxkm
            lbmn8twotwolcmctgk
            three85
            njdzndhqnd5three62dp4six
            three6fivehfb5dnljxtqmfourone9
            bbnvsslkzfour6one
            ceightwol7sevenfivethree
            7hpzd89pvlbt5
            nnvqfptmtpp8qlqfivednine39
            qoneightfourgvz6sixone
            9cdvtsnine
            seven3eight6
            1rxzvone
            2two1dqpvkkrnrzfjpzvcnltv4
            oneeightslplpbghzceightsmmrnonesix9seven
            5ninexktvoneninehgdv
            eight7sixxkpcxvlsneight5
            twonine217
            fkcxklz1sevenseven6fiveone9six
            676sixeightpsevenfourpnqhgc
            threefour2fn
            hkfourhthvlkbknlxbrftjjcrsvzzvpplfjpgpg9kddvkgcszn
            1fourthreeeighteightznj7
            one22bvjbvxjkfive18nine2
            ccxzfsqc8ltkbr7
            7sixntfhjflgvl9fivegpfql1
            9seventhree2
            9xksmtnjkgc76
            rr61four
            6ninenineztgcninecxgpvxptlninebdvhjxjgpzc
            9nfhdvlvmkgninedxppninenine14
            cmvlgmzxsixeight77twotwo
            hhzsgrxbl4five
            31qffcfdkvtfivekmrgkdd1
            4l2sixz8
            gdcvfpjxqmznngrm4pnlfour2ninetwotwo
            five684
            threegtmmlcvlbxdp4sixtwoneq
            one5zdlhtcdfvdsgjxrfq
            four1nine7
            13sfr91
            5eightfvgkhnnqpxqhdrfrpzgqlvpkeightpdqjjgmdqp44
            one67
            kmdtnkrxg8bdxfzrckpp5ghpmvskfourthree
            531xtmqrtwo
            1threenvzdptbkldmvclhxzvbcggtxfzhdtpfqbsix
            42nnzsgqgrvnvggqrvrcpdeight
            cqkzc4fourthreefour7sixgrfour
            jtcr5onehjfrrzfdpzzjthree652
            ninefgbqdphnrzddhtvqpgmnfivenine3
            lcrvln73three3jdnxzslxcfiveone
            threexqcsrfcjrtwo2four
            3txhsevenqtbksgzjtwoctfcbtsrg
            onethreeoneeightcv42zdtwoneml
            nineseven42one
            2flfjninesix2one32z
            75ninescskjtmljeightkspspsfz
            nq9oneightsgx
            4ninesixmsix2dgxdc
            6mlptkdqsxblnjltdcczfnlfpsix9
            eight7onenxzfpmvjsvspfdvgbzvvp3nine
            nine3fmvgbsseventhree6
            csrcmjreight6
            5twofour3fivezhseventwokdklzg
            eight4two2
            2threefivemz
            twothreesix1
            fivezcdkmdrjmh82ninetwo
            44jfvkbsdhl
            eightkplns7b1jtjone9
            qfrncbdbkdseven5lrshgtbthreetwo
            nine7gqp1
            sntjvhqpz34three8
            g8eightthree3fivevxszpstwonelr
            dklkqkfoursix5eight41sh
            vfour2kcc88
            one1bnpfnineqthmfmr
            ch9q32nonezrnsdhxqms
            27pcpfrtqxgbxcninefour
            one2grtjztkngkkvxmqg
            threevnvjptrcgfourzeightsix2
            xvgsfivehspdcxnncsfivesix24
            7vgmnmfone55sevensix2
            four575dmbrstkp58mgbs
            zhksthreeptqzsfd5
            sixfive7
            sixnjgvkzmmvthree88seventhreefhc5
            5ninesthkscgzqxgpchzvjbxrhrbmnqfrvcsix
            sixrdxxhld5
            bfdxttkrqsevenktchmtwo43
            zt9threethreeklsgdthree
            cgqsvpgnfldfxzbvm4glmxmbjsixeight
            fpbpdrms94
            jbhxtddlgseven4threelqztckdtjksevenone2dpmqcqhbrk
            88twotklvhqxqgkrgbfntrlfsfour9
            6nine6
            92four6
            smvfr622lxqdfhnljfjhsmpxzpxvhb9
            zxbplbxdsevenninehdeight8
            2ninembpclonezlkqmmtcrdc
            5two3njgngbvblvj75seven
            threeseven8six
            nine2four98five
            1dplqqcvrctjxvqhtprsixfourfourdqjr
            4fourqrkzzjcnn
            seventwosixtwo8
            7two6vmjmtpjv
            hnqvtone4
            five28sixhsztjrdmc4twonine
            88six
            jfczdhzvmhcmrqzbslhlnp5tzrzv
            2bs1mjbhsspftfiverncctjktfczxlx
            7zxrxkltqxsevensevendzhcfive99two
            648fcdfmtjxcbl
            8seventhreevqrq4psrk
            three1jzvhfbsjn7eight1
            bskckjnkgjxzlqxlsix9dqstkh
            77eightxbqhqbzbfive6jjnqbdhz2five
            kbdoneightmchpzkxbrtddnfour7clkgfvq6pbdbppfzfive
            ghnpgrjkthree93ninehgskzrvsvpfour
            sixseventwovtnfour5x
            ccn24shbqrvrpfivethree
            3fourtzdjqtvcmsrljgnqzsix98nine
            7fivefourninelttflrkhv2kgdbs
            5nmkrnvthree
            5onetj
            4brgvmfscxb3seven
            7sixthree5
            rkffhjbckhzcspcnineeighthpgjz2nine
            fcmzvnpdgckngfdlgmkmmsrcvft4kf
            twofour8eightseven
            jmzxl9v2
            dltwonedvpsqv3
            18ztdphsvqh54nhpthree3
            786kps
            nine98lmqhtrkscglcpk5two
            sevenxkbmtknr4seveneight
            sixnine86five1sixnine
            threevbgp5rhxghnvzz
            94sevenfourbcsevensix3one
            onethreezzdrlxl5lxqtwones
            qghxbxjkqgvf18pbdonefive
            ninedsq2mfmrmrcn
            dcclgjfvknqttvnxhcqtwoqdnzcmzqv4
            zcxtlnxtndnjzvdh7
            two46sixseven3
            3six8fourninexqxqkfftkkthreefour
            fourcnkm6btfscdstwodjkgbgvmj
            fqzbrjpvsqbjthkfhhztpcbpfjlqszrjtwo7
            zbmtvssixfourbjnfrf5
            15rpnjmmxnkrtgsevenndsixthree
            5eightone3five3snvcj
            two4sevenlcmgjfnltone4hklft
            vfhptr8dlqhgf7foureightwonp
            3onencvhmxgj1vfour5onejlqbjv
            fiveeight1
            one52ksevenn6
            two68seven9eightnine8
            thth374three
            xhmsqqbs5hpjtk
            znssdghfivefour3fivefml
            3tsjlkvcbq2
            six6895two17
            three8sixninef9two
            sixzktghc4ksvrffs
            4qqjxljz2ninesjjfdzjlrsixfour5two
            9rdptppnkkc4zr21six7
            jxzgeight4sixhlgjq7
            ml3sixeight
            nbpgljsvlrcqknzmfnmf3ssg2six7zfldglglsdplbr
            8319
            czlzhlgbninefive8
            8jkccgprsdg4ninesevenhsgrznseven
            sevenntwothreesixfour7
            5bqnrmflnd11
            9seven4five
            9ggqzbngglkshcpzqsgbbgjmvjvgptd
            one1tdhlkln9cmgmmgx4
            16qnxxg
            vvtbtcvvb1
            two31qndvcxk6
            4shnmhbxqzsvxq863threetwo
            2qfbrstrvt5three
            6vxhshgntkhsbgmrsk
            4txmbbjndbp5
            rkhszldlp5
            18gkhjsbz6onerxkkv
            5jjlnzqglkhtfnthree7five7hhvbrvjszone
            sevenfour12qzrltwogvtnrjtrcthreeone
            eightthree833
            9ninehj6fournqqzrkx
            sevenseven5jfqcseventwosevenlhrgcjqvsq
            threejlqlffzvjccjgdphfqzzsc4rch
            six9four3
            mcxkhseven9sixnine7gxmvcljh43
            fivebkbgeight4
            nqfjfph4hjnvkbl3fivedlhjlmdfivenine
            vpnlnsevenzfeightsixbtdrh2
            4xcblfour3fpzlfgfvgpbbrntworjxltzhdfour
            vrkzffiverbpxhfs46766
            28jgxnxxkfctwo7rfsmgskr4eightfive
            three1vdjhvzhseven4rngk3eightone
            jxqzhlqrvmtglntqjnoneqlhfjpqx6ninesgmncpfdfive
            sdtrgqxjzkone6
            9fivenine
            1mrfjpm
            six4pcsmonef
            jp3
            8onetpqbthjznsixfklfsix
            6onethree8oneninebsdgdrltkt
            two3sevenvkqbzq9b
            4spcktwoseven37n
            three7eight
            lblx738eightwom
            six2qtnrjmzzgjbjhhgjmnine75
            2sixbfpmttwovbvncfsevennineczdc
            1ptkkmb2
            kxxfxfb1fiveseven23
            eightfour4two61
            mdhchtfsgdp9rntwo
            eightxfhsixthreehjvsqpkjb7fpbt
            1zrt4frmhnxprcfourninefour
            sfoursevenninetwodhdgp25six
            lsthcqlgd3pqtfqxghcninenine2
            dprp1eight84731
            dzv5
            4s4onerq1xnrsgmqfb
            fg6kbdjmsv8eightsix
            clfhc1six1pmv
            19xghkrtckcc3
            cbscflvtwo3mjbjfnbltwosixnzlrqmpvqhnxftzbmm
            6ninefm62hdnmg3kpmzd
            djtjzbl3fivefivevggmxjmqpg7
            ts8qsh3sixtwopl
            fkfccvlplvfnbbfjmfmmjfgfcqvx6s
            nvpscsninetwo786twoonegptln
            fourthree4jsmsrjvsgm6nine
            ftlcnfour7bztjpxbqqhzsfoneightzk
            bvmghvx7six49nine6five
            3cpbpxgrsjcqnghjgfvjl5boneftbcdxmlrpdsdt
            snxdrfour9xcsxzznsbbddpskcpdqbgdjxdxb4
            dhqgpjtngqsjvs6vjn
            94six
            lscjdbmseveneight445nine5five
            pnsdrhtpsfppxfzgllhttwo4hh
            nineonethreeninepktwo1
            two7vpvbdtftdms1rkzznzh
            6rkvhrlbtbtcghjkdz8four4two2three
            eight7chbxczdhnhsqkqtzflkz8eightthreethree
            33fournine
            one4ninekdlgpczr
            74sevennbbx2rklgq
            sgjcsgv56kbqzknnpx9m
            7gtlqpqxlmfxjktnnzvnine1
            eight7bh7crn
            lnzpqpsdvsix68oneightz
            plmlvjk9qjfqqts4five
            2kxhbkjq9fivethreetwo
            tcjqfsbftfmd89five9two
            4two22
            rhxpkone6
            lbrpgdzctwo5sgvzsd
            nzkvfivezmbvhjrqt787
            qbgdxhfbrpjvnine4
            onejbtpqqbhlfivefour2fourseven
            mcgdfour5eightsix3zmkkqjddpxf
            four26
            hqhcrpbpxkrbtgfourfourrdcdgpf2gzkq2
            99zsjkvk8onefive
            4rzkninefivepmlgdzfp9hjvnbkkczznine
            twonflrcfjq7
            15fourfiveninethreetwofourxr
            mxthxdgjtkone9jzj
            53msztckkvpcttbmmf
            one6sixcrn
            seven5one216hxtwoone
            19six
            35dtqhkktsbv88eightkbjqvbjmhg
            7two1sevenf7bzjndtzps
            12sevenfiverjcllfsgzgkgthreefive
            ninefiveseventwo5twotwo
            1ndkdqhrmxtwolmzfcseven3jztfshgb
            9528
            47nineljpdzqrgp82
            9ppcbgxxdztseven
            4zskckqtmcjhdtwopjstbcnhlrrgvnhlrftwo6
            43four1
            7qgd23
            smfrpdvjjgfour2threesevenbprnjvdmpqqq
            fivelrnt6fhrnxqmtnprzp
            bmkjxvxglvsszhlxvqrnvklfive9lkczcqczgl
            72jlbpvl3fourbtbkxfkvlkvpvlkkzqc1
            5sixvpzsvfzpxlgdjxmtltwotwo3
            rpbssfzfmfivetwo4mtbcjcvrrjljsbzp
            lfivetwo219seven7rdcxg
            sixx1nx535
            boneight172rrvxlvcvqg2dfiveseven
            cbtg3
            87vbs8hzjmfjv
            hcthzxh7seven
            sgckpdjeightdcltwoptqfnstjsvbghsfjtwo2
            onecmj5fivegxxrzzmctqseven7xjrhdjm
            bhjjs2jznmjrxkchgxxbsvzhfntc
            xrmczvmsjmffrmcgh8
            jqsmzgvfhcjptcthreefpppkbvqxp45fcjglsqvccmgqsfxdz
            5btztwov
            gjssjkrz739
            57fourjxzpctphone2
            onecpgmqk28ninepbfqghlbmr5
            jbmqgkqeight4six
            six5784j
            pgjmrnine7fhqql744bklpmp1
            xkcbsjfrqk34sevenonesixfourrkrxqxjfive
            pfkfxbmxdtnbtrbztkz1
            ninefmqskmx3vrns
            6dksbglnsixzfpm5kkhcdmtfour7
            czvflxzzvppbqbhpd9prtzgrktrnhrvtbggssbvqsx
            78ninebnt4sixstlrhrhq
            9sevenfivefournhpxpcjvdcxrq
            sixkrdfq44mdslr
            5lvkmhc7nhvzvlsqrzsevenfourfqlksnzjc8n
            nphtwonemmxm8sppmh
            hshpxqr2fivekhlshrkzdhc
            3twokvxppfdptwo7
            9threeftbbmdjcvlnzpddv1sixeighttpt
            rxfgtc6four97
            1rjmjrppxvm
            7twohsxtnzhprcznkdpqrgv29
            6ninevd557
            1fivetdqbth8ninelfr
            mzgjhbcgnnine3ninenine
            1one5gsevennk3qvvbfxseven
            hvdcsxmkninefzfjfb4hz
            kvrrkjlrmfz2sevenlqhmhmmn1
            2mgrkmrsbeightwokl
            7cqtkvpttnineninesixsevengg
            vfsltkpdq3cskmgcjjfqsjlh
            558
            one7sixtcpzmreightbnjbblvhh4
            eightjhtklmrqjronesixtwo5
            sfnqdf81xvmfz55nkjvff3dvnhb
            foureighttwo9twoseventnbscgd
            7seven8bvqdjqpgone
            sixninecsix22zxcxsmrkmm6
            pksz9eight
            7nine9ptsbmrmqhkvxdvspxrdkqkglvlj
            83six1seven
            11fourgmjqllrzrfiveqcdtmsseveneightx
            687449eightsixdtpljbzjk
            9hbpkbcc8ninelrsseventwo
            glgkvmsgfjqddqpgzgzj97
            fxjnlg4
            mhxbghnmstxpjvjjgfpfivefourq5seven
            3hmfvkfbzglqdktwoninelqlfive
            74dxgxxcnlfs8vfsvsix
            9pjspsrhcxkninethreeseven
            2two6
            qvkkvbxgqxczfht6mrznks
            six8gzfsh76fourtlvnr
            lxpt2sdlrhlkdlpseven
            twomngg8three1fivevxsvgctql9
            vmt1
            nine9dlhnfjgd9
            84six72cgpfplfivefhngktthreeeightwop
            txbftrv3twoeightvqkcx6
            4beight8
            37rrsn
            xmsgfpfq1sixnnlzfhn3eightseven
            hzf4fournine19sixmmphbkxvzvmxm
            8vvtbdhjxhz
            4geightninelpqxfb1rz7
            fivedcjqmvglmeight1sevengnkvfkpqf
            3frmnfbsf624
            xlrcnfng3one4nxrdgj88
            qp4lvtfrkonefiveeightclkgrhsncq
            fourjfiveeight2mrcph
            8one4gqvlcqrmf9zchgn9n
            njzjone1lnjszl8three7five
            xdzhhx8nbptblrmn6fivergqzsbkjbxjvninenine
            dbxggptjjnxrds9nshnjzkp5sevenlmrtrpnnine
            szvfivetjkjzttnine8two6d
            rrtwonedzthree6four
            csxfourtwo41mblninebpr
            fourtwoslxxnsvx7
            two4hffnnzthreefourkzvmrj
            fivepltzmnbqglsjjthree29seven9
            ninesix4vrqxxlqnone9onexnf
            56hcjxrsnmkbssqdnl2stn
            fiverghvrmhq294mfourvbppnsbbhnfour
            59twoeightfblslfbmnh
            qnnqz3fkqtdhgeight
            eightfour1four
            zjkgstxbxt6
            jtlhveight76twosevenbqsgcz
            seveneightxzczkzvgpn2eightgkdqmqr8
            threefour1
            xhxgsshvlggggrfnvcsbjznqninezrmj9sixthree
            9onesixsix
            47eight
            22pgznxqzbfour47eightmsnhhzcxkj
            prpgssqtwo3threeseventfbbhf
            twobqrjq1zdhhrxcm
            nineskg12rlgmpbbdlxmk9twonel
            nine5twoeighttwoeight
            ccgvbjjgkrseventhreefour4oneqthpmfrsevengjqdf
            753
            8eighttwosixeightfourddbvbrm
            nine1one1
            twofivekvgtljnxdpfour18ptwolnj
            fourtwo69
            56vsfvgtwo
            644four
            1six9five
            7xgtjd4twoxrmdjclljtwoseven19
            nine6qklf5zjtnnksixcdxzhbnpcjnine
            one2ltklpthreeznlfljkbmm72
            twoflxnxnnmqmslskmx26
            seventwotwo6
            r63qtgvgdkndx6mfvd6
            nine45
            lhxksjfournineeightseven836
            vjkqonefflcvsjvdr7gccpxmjsevenfhseven
            6cmp2threeclh7sixkvgggspzmksglkpdm
            nine4qqmcmxgdv
            1g19gbmmrdfour
            59eightqgrgrlgeight
            4xgrkgn
            krhsixxhdvf94eight7
            mf8rvllxfjmgz6hqjbjthreemeight
            rdlpxzhlr2lvzmcpgvtwo4lpmzfivethree
            nine4five9onefiveeight
            twokjmhnzgqzbbcgc6bgk88pp
            four151
            kkxnmspbdrzkqbsix3five3
            grfourhjfdsxzsrl14qzt6nvgs
            214
            tjlpbqseventhree6hkxzjzqc
            seven5five
            h467sevenlxfq5one
            vprmr3ztxgtddxfnllsevenbzgr
            five4trqmxfqrzjldccrlfivezsz7
            2cdjgcglone5qsfour7jznkjmvtj
            kndjzfrkxsixfour9qltvsdjzrdfvsrmhlndv
            84sevenfivebzxqgvhtpphtfltwonine
            1nloneseventwoxljs5xllrqdrbpcmh
            j2dqscdpbbonethreeqxhmvd54
            nine2eightnine7qqtj3one
            ninefiveqrzkvhghr18mlxnmfg
            four6kvbxpjcclz
            sevencjphdmtrdthreetworpxdhd5bdrcczone
            twofour35five
            7567lbf14
            8ninebfxsrfour24
            vmzpnine31
            dzzdqcvsjmg6fourninesevenqqrglpr
            three3pnvtfphg
            eight5three
            55hlfour
            44zksglcrvjhtwoljvb9
            gspmkpzkmchnfour5bpvlldgthree
            nineoneone3seven
            xqnkrxlbdbhrjffvfztjgtrrg6lvjsncmc58
            nineninesxgsbsfzjrfourqttfjpkcxtcdmkhhfb9seven
            dpzxgtmsq45vvqsbtsix1
            1one7
            2twok7six
            gzkzsjfggjfgvjjd2lgvzcqxh828three
            6ninetwotwo8rfqlt6
            4fivesevenvsgdsthfbldrmtzqrzkv
            five3five78three4
            six3r95fiveeightwoxl
            41threeeightrfcrxnine8nine
            3srkd88sixeight7dlvmz
            sixsix41kktsztnh
            pvxthreenine5
            cone3threethreenine48
            3nrdl63dtthlsbonejj
            tg112qhrmt
            ninepksrfnlqtq9pgzslnzknngnkhnlglhppfour
            four7ninepzmhkone
            86hffvsqz2three
            beightd1
            9seven1
            mlllrbcfvmtwosixgdtwo1threeoneightx
            165rpmfzt2sixvnkf
            6pnskbqrqsnine
            two3vkthx
            jgnkrq2vqvdkvpmdx
            lkrmlfvkqgtsrqlqqxtsssvmstxkvbgsf4
            dcmkvgnkfcsevenfiveeighthv555
            twosevencf586lzgmccsntwo
            three14jldjlcrlpvnvrfnkctlhseven
            zccvgvqn34gtpfnjppbcgssevenvqzzzvxshsevenbb
            htpsrxhc7btdqkjnine527x
            zvhx6xnlttqthreetwo4933
            9rxkqfivethreeoneptwovcpbone
            43dtzdvzvmftrsrpvsb141
            vnlkblpvr8five
            gjkqfs7sevenoneninefourzshjzsqhc3three
            threeghshjlgsjp6vkhklk
            5vvgrfourvzsljgmtkldfour
            mjbklkgrbgfourgbmkrrxdg3five5
            two7threesixfour
            zzfgzq2two2jjhgt
            bxptwonedgc8
            2bcpt7
            four4648four
            617rdpbn6
            nine82
            nine4fvcvtjfzpfivelgnbone21
            4sixpt5314
            sixsix5seven
            jdjt2
            btg3mjx5six
            6sevennr6two9rmrhseven
            ztwone1eightfbzdndvkpchchk
            deightwothreethreeeight4g5bjbmltwotwo
            threessm2
            vmslkbkz54three93klvpqzrdg3
            ninefourpxjjb4dxbrtztwonefl
            threeghtcbbllbpnxqxljhnztsx37eight2
            qdnblmhjbkkvdjsf3two
            fourkgrlmseven8six
            4fourthreefivenine433
            eight4eightrsjhvvfcrseven6ppdhfg
            9onesevennine11dnjoneightgs
            smqslvrxz9hjssnvzbbtzcdnmcfour1qqponeightj
            vpbffb4eightthreefive8one21
            4eightone664knsdxgdhvjz7
            78lkbmrxsthtfourninefivedcnccjfsvnfrjrth
            9sevenfoureight6shcvvsxslpxvfkvnfpr8
            hstncm2
            5tsstfnsqmlppvrksrflfpndjpqv1thgkrmpkz
            hmzdlmdeightfive2onethree4
            9nine33pzzsq1three32
            zkfjtzfvn8
            qfzsktslpshtcpbkb86
            371twomjbkmbzps1
            dsnlmp5twonem
            9fourbrqtrlnhmtwo5
            8four7
            threetwo6mkvklvqrconenine
            98five9sixeight67
            eightsix2cggvpkdsjpbxvgxld
            8sevenjfncbltthreergzxcsvbseven
            fbqeightwoonefive72ninecxfscgxxjlr7
            92mlczhv26sevenkhrf
            seven465four
            6one1sixjdq
            54six
            rbmvkhbmnzpmsix14
            njbzgfnpdrfivefoursfftlhqfcgtlnnqdkvbljksdkhxc4
            795
            6cpgtvqone
            cbxkdzgmbm8three2five4
            sevenhbzspvkx5four11mhfrkgzdx5vvqnp
            6czf8
            sevenllfztnqjmdqfjfrnxmnrs51
            2mjpkvtgbvnbqhcgql31
            1867njtwothree4gccbpm
            8sbfnkbjgx
            cvvskndsjftkchlmlthdhkmbnhrvlthreetpxthhzxs5threeseven
            46twoeighteighttwonineddprrjmcp
            threeseven12
            17pphl13fourclvpvzmnprd2
            eight4jlqqtm
            sevenfournvng895
            4ninebmhgsvjjzxpthzcntrvqv
            fourninelr3rnmxtjcjnsixlvctfqgmlrq
            zzzd2fivexseven46sevenk
            srmxntxslsix2jhsmbfprppktwoseven
            six3four82b8
            gg5
            vmkzvfhxjcgdg9
            nx7
            dktphpghj17snmrmpghvnm3
            sdjtwonenine5mlrc9seven
            224vrbbhfivegfkfxjkdmf3sjfthjzrstwo
            onemqrllbpgthree2five7seven
            ninedvmlvsrxnfiversrxbninethree75
            two5twozfcbrt
            seven1seven4one41eight
            three8threefive9chxdrqnbn
            37csnlskpqnckseven7xsspxmhbbpbb
            seven17
            2twoeightthreetsmkjrptpl4tfmbkb
            nzfrqpht1bqvcdklcfrqfhxjdbkhsgkqbckqlfhtr
            onefive4one
            1cqqgseven3eight7four
            eightsix1eightmsvct4five9
            1fourngkfour751
            cfnsixrnkvt1twofcsgjfzh22
            xbzdhlggcsnl1mbqpjdk
            onebskbxdmq1
            8mlxrkcmlxfhr
            2nineone2four5jxhtjfmp
            tqd8twonineone12one
            8cfhl59xl
            2hvhgdqfeight4clgnt6csknfhbhxbnrsztlthree
            24bxhkdnjlkdnzh3dbthg
            3twoonefoureightcffkkvhloneseven8
            eight2eightwox
            seventhree9threethreefive5
            89nvccjlknkqqtxpnvhccmzjfbk4
            rlsvtx6sevenxkmbfninefourtjkvcnstrg
            1lnjsxbtrls3
            tpcqt7sixxcnfxsone3one
            pl34fournine
            3crbjhlcvxxv7fivetfsqsk7dhfmrnnrfmthree
            rjptwone898twosixnmrfjkrqsnvjpqkfjvn
            sevenpflchbthreek4fjfmg
            twolpt4vrqtdjkxjc3eight
            threethreeone3bpchonenpbpgxsrbp
            2nineone77jmbfveight4
            six6seven58
            jvbfsqdkldpk9sixrjqphtpnine
            hgf7
            6bljhtdsrzgsrszsptv
            8sevenkrpqkfxdcn7eightfour7lfpbtztlmfg
            98two
            qczm1sevenfive9fivefive
            eighttwo2hdzpzpvmjzs
            5sdlqqgdtcxvpzk
            8fivedjfndxffk2onesevensix
            feightwo986psvpsgl
            ceighttwo42312rz
            qgszndm73rvglpjkxdtvv62
            one74sevenone4grqfpnq
            dkrljltthree7eight9xlsvg9
            2tpr
            4gknmhsone7two
            5fiveeightpkndrfourjkvl6
            fourfive4four
            one5pdkvd2
            fiveseven2threeonedmvsfour3
            jzjp778zhvb1
            9xrgklr1qtz313
            nrqjninesevenlkbmbbhbfive1four
            sevenxrb1sgjchdzsn
            five5svqbznine3
            fflq2
            6seven1fjnmfgkfourthreethree
            coneight6msgnine
            9eight6fdfpqlqtwotwo
            fourknl3threethreethlsgqsmtjvdx3nine
            2sixprgbxgpbvtwosevenhbgcqheight
            7onesevenbvltbbvxzhhn
            dbbjhvsqtsdxvllvcqh124hcfsq7
            4two66nineeightzjrzhgnxr
            nm5573xxrmsksix2tpzg
            87625cjnkhqqk
            nine6twofiveone
            9qztffive
            24fourfourqtl19
            prxeightgsxjztsfsxxpljpjcrmbhzqr1phrlvmhszjndvtn
            5twofour3dpmtsjffkvvtone9gbsvtt
            lhbktljvlfmllnzonexpjsmzfcgonefour344
            four2hh7eightnine3
            kltvxtjgqjjzdmzkkthree6cbnlgvzk8
            9qsq
            6qfivefivecdxkm3kqtgffsp
            three2ninetwozbpfrseventwofive
            5vvqvl91fivesix
            eightrgkppeight79ktrkmb55
            1f7onetjzphmc
            2qtxpbzqxskzdmvgxmj1
            three9tdttvltpeightqbxspmshbx52two
            kdlcf7gdxhtpff5qstgjqzczr
            7fiveeight9fxdvnsone
            4hxdhfskfhmj84five
            hv85
            fourtwostcvthree3rsqzgfdkeight8four
            6zpnhbsdleight
            2dffflrlt
            seven5clhhhreight
            315twonehz
            five4sevenvlhnczltpxtskstcxqmfkstgnine
            sevenbjl2two8drpbmddkfourseven
            dvp5one
            twothreeonejone8two
            hcone4gxpcv
            1qeighthfzzsvsvtph
            tfivehpstfxnine8two
            jpvprgf18vdxvhzksnngj
            3fivebnzjjjnkqsix95four69
            54hcnlonesblqvtnh3qhcnine
            rzmjgxcxtfive9qspggmrsntwosix
            ntkfivefive9ninevmcnrfznzfour2
            5jeightlvd9kdzsscqchjbrfive
            fbsthree3oneeight
            6ninethree
            9gxfxdtcv
            seven6sbmhmlkjk9clmfive5dbrgflgtbkhtkqlt
            twot2nine5
            2fhfzr19
            jjzvfivevghv86qkqlnndv
            7hnccfvxlnineeightfrcjfdzhlnine4
            734five1
            zmmzsdhthreetwo7two1mzbcsnhmqllsftqzmnhjtbdrff
            twofivegbtpj4three
            8c85six
            sixcjdthhf3twoonezztshrfbsxfivexthf
            rzqfivethreepzonefhfvc8
            ninethreevsgqlfdgsnxbdrkz92
            one9tv28hflpgxgjlz
            gbps3one4gjdp4eight1
            fournfndjrjone3ninentlllvjpzvjx9
            467pdqhfsmls
            six56lcfpblnthreeonerd1
            four5cnxtgsrhmdmlddcdkmmglqhtqgcj
            9sevenonesixrlvctrlndm
            fivesixzxfive22
            7ninesevensix
            sevenfdjmc89two5
            svtxm42ztnzxxtpfzgjcmzkb
            4r
            2six1
            fivezbdqtvbhsx1zgqzgjdzjs
            83n
            85threedm2xmsfhhbpshsxqhn
            9twoeight9fgkrgsdz2
            pvqqdfcfourxqvsfcs1two9seven
            5qfhhlqdr
            5sevenlnrnqjq77eight5
            fourninesevenqgpqqhrsevenseven24
            dtlqxk5six
            eightnine2eightnineeight
            v2oneonegxdngmtv
            4bf6rfnfive
            eightkmdxmccv4vrvjlpgcqthree787q
            mtqxjrcn1two9fourncghmnbsseight
            ninebqqbmqklht6mxfdsxdtwothreehrcvlzkqg
            2eight8fmktlf
            vjchzt7btthreesix1tcngpbtzsfmvsx
            sjv8
            ncqpkzh5twooneoneqfxlqbjjhqsrlkhvdnvtbzpcbj
            449three45three
            """;

    public static int trebuchet(String input) {
        String[] arr = input.split("\n");
        int sum = 0;
        for (String str : arr) {
            String tmp = "";
            for (char c : str.toCharArray()) {
                if (Character.isDigit(c)) {
                    tmp += String.valueOf(c);
                    break;
                }
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                if (Character.isDigit(str.charAt(i))) {
                    tmp += String.valueOf(str.charAt(i));
                    break;
                }
            }
            sum += Integer.parseInt(tmp);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trebuchet(input));
    }
}
