<div align=center>
    <p>Fork of <a href="https://github.com/PaperMC/Paper">Paper</a> aimed at being the biggest meme and adding tons of random stuff.</p>
</div>

## How To (Server Admins)

### **IT IS HIGHLY RECOMMEND TO NOT USE PAPYRUS AS THIS IS A MEME FORK**

Papyrus uses the same paperclip jar system that Paper uses.

There is no easy way to download the latest build as *I* do not want people to seriously use this on production servers. It is fine to mess around with this jar on test servers as any patch created for this most likely will be randomness. 

You will need to clone the repo and then use `gradlew applyPatches` `gradlew reobfJar` to build the jar, which then is found in `Papyrus-Server/build/libs`

### **AGAIN IT IS HIGHLY RECOMMEND TO JUST USE PAPER OR TUINITY INSTEAD**

#### Creating a patch
Patches are effectively just commits in either `Papyrus-API` or `Papyrus-Server`.
To create one, just add a commit to either repo and run `./gradlew rebuildPatches`, and a
patch will be placed in the patches folder. Modifying commits will also modify its
corresponding patch file.

## License
The PATCHES-LICENSE file describes the license for api & server patches,
found in `./patches` and its subdirectories except when noted otherwise.

The fork is based off of PaperMC's fork example found [here](https://github.com/PaperMC/paperweight-examples).
As such, it contains modifications to it in this project, please see the repository for license information
of modified files

