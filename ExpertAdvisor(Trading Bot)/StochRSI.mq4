//+------------------------------------------------------------------+
//|                                                     StochRSI.mq4 |
//|                                                    Cade M Forbes |
//|                                             https://www.mql5.com |
//+------------------------------------------------------------------+
#property copyright "Cade M Forbes"
#property link      "https://www.mql5.com"
#property version   "1.00"
#property strict

#define MAGICNUM  1
//--- input parameters
//input int      RSIPeriod = 3;
//input int      UpDownPeriod = 2;
//input int      ROCPeriod = 100;
//input int      Price = PRICE_CLOSE;
input double   Lots = 0.1;
input double   DecreaseFactor = 3;
input double   MaximumRisk   =0.03;
input int      SlippagePips = 3;
input int      SleepTimerHrs = 4;
input int      maxStopLoss = -250;

input int      SMAPeriod = 169;

input int      StochBuyOpen = 15;
//input int      RSIBuyOpen = 36;
input int      StochBuyClose = 75;
//input int      RSIBuyClose = 70;

input int      StochSellOpen = 80;
//input int      RSISellOpen = 69;
input int      StochSellClose = 16;
//input int      RSISellClose = 42;

//+------------------------------------------------------------------+
//| Expert tick function                                             |
//+------------------------------------------------------------------+


bool canPlaceTrade(int _iHour){
   int    losses=0;
   int    orders=HistoryTotal();
   
   for(int i=orders-1;i>=0;i--)
        {
         if(OrderSelect(i,SELECT_BY_POS,MODE_HISTORY)==false)
           {
            Print("Error in history!");
            break;
           }
         if(OrderSymbol()!=Symbol() || OrderType()>OP_SELL)
            continue;
         //---
         if(OrderProfit()>0) break;
         if(OrderProfit()<0) losses++;
        }
    
    
    if(losses >= 5){
      int liLastClose = 0;
      for (int i = 0; i < OrdersHistoryTotal(); i++){
         if (OrderSelect(i, SELECT_BY_POS, MODE_HISTORY) == false) continue;
         liLastClose = MathMax(liLastClose, OrderCloseTime());
      }

      if (liLastClose+_iHour*3600 > TimeCurrent()){
      return(false);
      }
  
    }
     return(true);
}


double LotsOptimized(){
   double lot=Lots;
   int    orders=HistoryTotal();     // history orders total
   int    losses=0;                  // number of losses orders without a break
//--- select lot size
   lot=NormalizeDouble(AccountFreeMargin()*MaximumRisk/1000.0,1);
//--- calcuulate number of losses orders without a break
   if(DecreaseFactor>0)
     {
      for(int i=orders-1;i>=0;i--)
        {
         if(OrderSelect(i,SELECT_BY_POS,MODE_HISTORY)==false)
           {
            Print("Error in history!");
            break;
           }
         if(OrderSymbol()!=Symbol() || OrderType()>OP_SELL)
            continue;
         //---
         if(OrderProfit()>0) break;
         if(OrderProfit()<0) losses++;
        }
      if(losses>1)
         lot=NormalizeDouble(lot-lot*losses/DecreaseFactor,1);
     }
//--- return lot size
   if(lot<0.1) lot=0.1;
   return(lot);
}



int GetSlippage()
{
   double CalcSlippage;
   int CalcDigits = MarketInfo(Symbol(),MODE_DIGITS);
   
   if(CalcDigits == 2 || CalcDigits == 4) 
      CalcSlippage = SlippagePips;
   else if(CalcDigits == 3 || CalcDigits == 5) 
      CalcSlippage = SlippagePips * 10;
   return(CalcSlippage);
}

void OnTick()
  {
//---
   int orderSend;
   double stoch = iStochastic(NULL, 0, 14, 3, 3, MODE_SMA, 0, MODE_MAIN,0);
   double rsi = iRSI(NULL, 0, 14, PRICE_CLOSE, 0);
   double sma = iMA(NULL,0,SMAPeriod, 0, MODE_SMA, PRICE_CLOSE,0);


   if(OrdersTotal()!= 0){
      
      for(int i = 0; i < OrdersTotal(); i++){
         if(OrderSelect(i,SELECT_BY_POS,MODE_TRADES)==false) break;
         if(OrderMagicNumber()!=MAGICNUM || OrderSymbol()!=Symbol()) continue;
         //--- check order type 
         if(OrderType()==OP_BUY)
            {
               //double vbid    = MarketInfo(Symbol(),MODE_BID);
               if((stoch>StochBuyClose /*&& rsi>RSIBuyClose*/) || (Close[1] < sma) || (OrderProfit() < maxStopLoss))
                  {
                     if(!OrderClose(OrderTicket(),OrderLots(),Bid,GetSlippage(),White))
                     Print("OrderClose error ",GetLastError());
                  }
               break;
            }
         if(OrderType()==OP_SELL)
            {
               //double vask    = MarketInfo(Symbol(),MODE_ASK);
               if((stoch<StochSellClose /*&& rsi<RSISellClose*/) || (Close[1] > sma) || (OrderProfit() < maxStopLoss))
                  {
                     if(!OrderClose(OrderTicket(),OrderLots(),Ask,GetSlippage(),White))
                     Print("OrderClose error ",GetLastError());
                  }
               break;
            }
      return;
      }
   }
   else{
      if(canPlaceTrade(SleepTimerHrs)){
         if(Close[0] > sma){
            if(stoch < StochBuyOpen /*&& rsi < RSIBuyOpen*/){
               orderSend = OrderSend(Symbol(),OP_BUY,Lots/*Optimized()*/,Ask,GetSlippage(),0,0,"",MAGICNUM,0,Blue);
               return;
            }
         }
      
         else{
            if(stoch > StochSellOpen /*&& rsi > RSISellOpen*/){
               orderSend = OrderSend(Symbol(),OP_SELL,Lots/*Optimized()*/,Bid,GetSlippage(),0,0,"",MAGICNUM,0,Red);
               return;
            }
         }
            
         
      }
   }
  }   
   
  
//+------------------------------------------------------------------+
