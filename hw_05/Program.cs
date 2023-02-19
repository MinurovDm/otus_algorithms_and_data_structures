namespace hw_05;

using System;

class Program
{
    private static void Main(string[] args)
    {
        // Console.WriteLine(GetKingMoves(20));
        Console.WriteLine(GetHorseMoves(20));
        Console.WriteLine(GetPopCount(GetHorseMoves(20)));
        Console.WriteLine(GetPopCount2(GetHorseMoves(20)));
    }

    private static ulong GetKingMoves(int pos)
    {
        var k = 1UL << pos;
        const ulong noA = 0xfefefefefefefefe;
        const long noH = 0x7f7f7f7f7f7f7f7f;
        var ka = k & noA;
        var kh = k & noH;
        return
            (ka << 7) | (k << 8) | (kh << 9) |
            (ka >> 1) | (kh << 1) |
            (ka >> 9) | (k >> 8) | (kh >> 7);
    }

    private static ulong GetHorseMoves(int pos)
    {
        var k = 1UL << pos;
        const ulong noA = 0xfefefefefefefefe;
        const ulong noAb = 0xfcfcfcfcfcfcfcfc;
        const ulong noGh = 0x7f7f7f7f7f7f7f7f;
        const long noH = 0x7f7f7f7f7f7f7f7f;

        return
            noGh & (k << 6 | k >> 10) |
            noH & (k << 15 | k >> 17) |
            noA & (k << 17 | k >> 15) |
            noAb & (k << 10 | k >> 6);
    }

    private static int GetPopCount(ulong mask)
    {
        var cnt = 0;
        while (mask > 0)
        {
            cnt += (int)(mask & 1);
            mask >>= 1;
        }

        return cnt;
    }

    private static int GetPopCount2(ulong mask)
    {
        var cnt = 0;
        while (mask > 0)
        {
            cnt++;
            mask &= mask - 1;
        }

        return cnt;
    }
}