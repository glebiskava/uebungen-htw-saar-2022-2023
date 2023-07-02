#include <stdio.h>

int main() {
	double netto;
	double brutto;
	double mwst;
	double skonto;
	double final;

	printf("Geben Sie einen Geldbetrag ein : ");
	scanf("%lf", &netto);

	mwst = netto * 0.2;
	brutto = netto + mwst;
	skonto = brutto * 0.02;
	final = brutto - skonto;

	printf("Nettopreis\t\tEuro %.2f\n", netto);
    printf("+ 20%% MwSt\t\tEuro %.2f\n", mwst);
    printf("=====================================\n");
    printf("Bruttopreis\t\tEuro %.2f\n", brutto);
    printf("- 2%% Skonto\t\tEuro %.2f\n", skonto);
    printf("=====================================\n");
    printf("Rechnungsbetrag\t\tEuro %.2f\n", final);

	return 0;
}

