using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.PlatformConfiguration.AndroidSpecific;
using static System.Net.Mime.MediaTypeNames;

namespace App1
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }
        private void Button_Click(object sender, EventArgs e)
        {
            double x = 1.0;
            string input1 = inputFunction.Text.Replace("x", start.Text);
            string input2 = inputFunction.Text.Replace("x", end.Text);
            double result1 = Convert.ToDouble(new DataTable().Compute(input1, null));
            double result2 = Convert.ToDouble(new DataTable().Compute(input2, null));
            double h = Convert.ToDouble(end.Text) - Convert.ToDouble(start.Text);
            double result = 0.5 * h * (result1 + result2);
            answer.Text = result.ToString();
        }
    }
}
