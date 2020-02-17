using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Data.Entity.Core.Objects;
using Zadatak.Models.Database;
using System.Data.SqlClient;

namespace Zadatak.Controllers
{
    public class ServiceController : Controller
    {
        
        // GET: Service
        public ActionResult Index()
        {
            var db = new PPPKEntities5();
            var data = db.GetServisi();
            return View(data.ToList());
        }

        // GET: Service/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Service/Create
        public ActionResult Create()
        {
            //var db = new PPPKEntities5();
            //ViewBag.Vozila = db.GetVozila();
            //ViewBag.Kategorije = db.GetKategorijeTroskova();
            return View();
        }

        // POST: Service/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            var db = new PPPKEntities5();
            try
            {
                // TODO: Add insert logic here
               // SqlParameter param1 = new SqlParameter("@cijena" , collection.)
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Service/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Service/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Service/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Service/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
