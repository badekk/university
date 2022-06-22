using NUnit.Framework;
using System;
using RPNCalculator;

namespace RPNTest
{
    [TestFixture]
    public class RPNTest
    {
        private RPN _sut;
        [SetUp]
        public void Setup()
        {
            _sut = new RPN();
        }
        [Test]
        public void CheckIfTestWorks()
        {
            Assert.Pass();
        }

        [Test]
        public void CheckIfCanCreateSut()
        {
            Assert.That(_sut, Is.Not.Null);
        }

        [Test]
        public void SingleDigitOneInputOneReturn()
        {
            var result = _sut.EvalRPN("1");

            Assert.That(result, Is.EqualTo(1));

        }
        [Test]
        public void SingleDigitOtherThenOneInputNumberReturn()
        {
            var result = _sut.EvalRPN("2");

            Assert.That(result, Is.EqualTo(2));

        }
        [Test]
        public void TwoDigitsNumberInputNumberReturn()
        {
            var result = _sut.EvalRPN("12");

            Assert.That(result, Is.EqualTo(12));

        }
        [Test]
        public void TwoNumbersGivenWithoutOperator_ThrowsExcepton()
        {
            Assert.Throws<InvalidOperationException>(() => _sut.EvalRPN("1 2"));

        }
        [Test]
        public void OperatorPlus_AddingTwoNumbers_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("1 2 +");

            Assert.That(result, Is.EqualTo(3));
        }

        [Test]
        public void OperatorTimes_AddingTwoNumbers_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("2 2 *");

            Assert.That(result, Is.EqualTo(4));
        }

        [Test]
        public void OperatorTimes_DividingBy0_ShouldThrowException()
        {
            Assert.Throws<DivideByZeroException>(() => _sut.EvalRPN("0 2 /"));
        }

        [Test]
        public void OperatorMinus_SubstractingTwoNumbers_ReturnCorrectResult()
        {
            var result = _sut.EvalRPN("1 2 -");

            Assert.That(result, Is.EqualTo(1));
        }

        [Test]
        public void ComplexExpression()
        {
            var result = _sut.EvalRPN("15 7 1 1 + - / 3 * 2 1 1 + + -");

            Assert.That(result, Is.EqualTo(4));
        }

        [Test]
        public void ComplexExpressionWithPrefixes()
        {
            var result = _sut.EvalRPN("#F B111 1 1 + - / #3 * B10 1 1 + + -");

            Assert.That(result, Is.EqualTo(4));
        }

        [Test]
        public void Factorial_of_1()
        {
            var result = _sut.EvalRPN("1 !");

            Assert.That(result, Is.EqualTo(1));
        }

        [Test]
        public void Factorial_of_6()
        {
            var result = _sut.EvalRPN("6 !");

            Assert.That(result, Is.EqualTo(720));
        }

        [Test]
        public void Factorial_of_15()
        {
            var result = _sut.EvalRPN("15 !");

            Assert.That(result, Is.EqualTo(1307674368000));
        }

        [Test]
        public void Binary_of_5()
        {
            var result = _sut.EvalRPN("B101");

            Assert.That(result, Is.EqualTo(5));
        }

        [Test]
        public void Binary_of_10()
        {
            var result = _sut.EvalRPN("B1010");

            Assert.That(result, Is.EqualTo(10));
        }

        [Test]
        public void Binary_of_551()
        {
            var result = _sut.EvalRPN("B1000100111");

            Assert.That(result, Is.EqualTo(551));
        }

        [Test]
        public void Decimal_of_1()
        {
            var result = _sut.EvalRPN("D1");

            Assert.That(result, Is.EqualTo(1));
        }

        [Test]
        public void Decimal_of_10()
        {
            var result = _sut.EvalRPN("D10");

            Assert.That(result, Is.EqualTo(10));
        }

        [Test]
        public void Decimal_of_150()
        {
            var result = _sut.EvalRPN("D150");

            Assert.That(result, Is.EqualTo(150));
        }

        [Test]
        public void Decimal_of_1500100900()
        {
            var result = _sut.EvalRPN("D1500100900");

            Assert.That(result, Is.EqualTo(1500100900));
        }

        [Test]
        public void HexaDecimal_of_1()
        {
            var result = _sut.EvalRPN("#1");

            Assert.That(result, Is.EqualTo(1));
        }

        [Test]
        public void HexaDecimal_of_155()
        {
            var result = _sut.EvalRPN("#9B");

            Assert.That(result, Is.EqualTo(155));
        }

        [Test]
        public void HexaDecimal_of_1999()
        {
            var result = _sut.EvalRPN("#7CF");

            Assert.That(result, Is.EqualTo(1999));
        }

        [Test]
        public void HexaDecimal_of_1500100900()
        {
            var result = _sut.EvalRPN("#5969B924");

            Assert.That(result, Is.EqualTo(1500100900));
        }

        [Test]
        public void MixSystem_Add_of_199()
        {
            var result = _sut.EvalRPN("#BA D13 +");

            Assert.That(result, Is.EqualTo(199));
        }

        [Test]
        public void MixSystem_Substract_of_155_by_10()
        {
            var result = _sut.EvalRPN("B1010 #9B -");

            Assert.That(result, Is.EqualTo(145));
        }

        [Test]
        public void MixSystem_Divide_of_150_by_10()
        {
            var result = _sut.EvalRPN("B1010 D150 /");

            Assert.That(result, Is.EqualTo(15));
        }

        [Test]
        public void MixSystem_Multiply_of_99_by_98()
        {
            var result = _sut.EvalRPN("#63 B1100010 *");

            Assert.That(result, Is.EqualTo(9702));
        }

        [Test]
        public void MixSystem_Divide_by_0_Exception()
        {
            Assert.Throws<DivideByZeroException>(() => _sut.EvalRPN("B0 D222 /"));
        }

        [Test]
        public void MixSystem_NoOperator_Exception()
        {
            Assert.Throws<InvalidOperationException>(() => _sut.EvalRPN("D150 #2"));
        }
    }
}