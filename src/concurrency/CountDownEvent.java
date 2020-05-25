#include <stdlib.h>

int main (int argc, char *arg[])
{
    fork ();
    int a = fork();
    if (a) {
        fork ();
    } else {
        char *argv[2] = {"/bin/ls", NULL};
        execv (argv[0], argv);
        fork ();
    }
}
